package tests

import com.sksamuel.hoplite.ConfigLoaderBuilder
import com.sksamuel.hoplite.addResourceSource
import config.Config
import io.gatling.javaapi.core.CoreDsl
import io.gatling.javaapi.core.CoreDsl.exec
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpDsl.status
import jodd.util.MapEntry

/**
 * Documentation: https://gatling.io/docs/gatling/reference/current/core/injection/
 */
abstract class BaseSimulation : Simulation() {

    // Read and shuffle computer IDs from a CSV file
    internal val ids = CoreDsl.csv("computer_ids.csv")
        .readRecords()
        .flatMap { it.entries }
        .map { it.value }
        .asSequence()
        .shuffled() as Sequence<String>

    // Load configuration from a YAML file
    private val config = ConfigLoaderBuilder.default()
        .addResourceSource("/configs.yaml")
        .build()
        .loadConfigOrThrow<Config>()

    // Define the HTTP protocol with common headers
    val httpProtocol = http.baseUrl("http://localhost:3000")
        .acceptHeader("application/json")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("en-US,en;q=0.5")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

    // Function to perform a POST request to the bowling-score endpoint
    fun postBowlingScore(
        frames: List<Int>
    ) =
        exec(
            http("bowling-score")
                .post("/bowling-score")
                .body(CoreDsl.StringBody(frames.toString()))
                .asJson()
                .check(status().shouldBe(201))
        )

        fun search(
        ids: Sequence<String>
    ) =
        exec(
            http("search")
                .get("/")
                .queryParamSeq {
                    ids.toList().take(1).map { MapEntry("p", it) }
                }
                .check(status().shouldBe(200))
        )
}
