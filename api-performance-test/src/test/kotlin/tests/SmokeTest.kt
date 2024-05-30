package tests

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.http

class SmokeTest : BaseSimulation() {

    // Sample frames data to be sent in the POST request
    private val frames = listOf(10, 9, 1, 5, 5, 7, 2, 10, 10, 10, 9, 0, 8, 2, 9, 1, 10)

    // Updated scenario to perform a POST request to the bowling-score endpoint
    private val bowlingScoreScenario = scenario("BowlingScoreScenario").exec(postBowlingScore(frames))

    init {
        setUp(
            bowlingScoreScenario.injectOpen(rampUsers(100).during(10))
        ).protocols(httpProtocol)
    }
}
