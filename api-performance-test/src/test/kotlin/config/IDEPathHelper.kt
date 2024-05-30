package config

import java.nio.file.Path
import java.nio.file.Paths
import java.util.Objects.requireNonNull

object IDEPathHelper {
    private val projectRootDir = Paths.get(requireNonNull(javaClass.getResource("gatling.conf"), "Couldn't locate gatling.conf").toURI()).parent.parent.parent
    private val mavenTargetDirectory = projectRootDir.resolve("target")
    private val mavenSrcTestDirectory = projectRootDir.resolve("src").resolve("test")

    val mavenResourcesDirectory: Path = mavenSrcTestDirectory.resolve("resources")
    val mavenBinariesDirectory: Path = mavenTargetDirectory.resolve("test-classes")
    val resultsDirectory: Path = mavenTargetDirectory.resolve("gatling")
}