sealed class Build(
    val name: String,
    val isMinifyEnabled: Boolean = false,
    val isDebuggable: Boolean = false,
    val enableUnitTestCoverage: Boolean = false,
    val applicationIdSuffix: String = "",
    val versionNameSuffix: String = ""
) {
    object Debug : Build(
        name = "debug",
        isMinifyEnabled = false,
        isDebuggable = true,
        enableUnitTestCoverage = true,
        applicationIdSuffix = ".debug",
        versionNameSuffix = "-DEBUG"
    )

    object ReleaseExternalQa : Build(
        name = "releaseExternalQA",
        isMinifyEnabled = false,
        isDebuggable = false,
        enableUnitTestCoverage = true,
        applicationIdSuffix = ".releaseExternalQA",
        versionNameSuffix = "-QA"
    )

    object Release : Build(
        name = "release",
        isMinifyEnabled = true,
        isDebuggable = false,
        enableUnitTestCoverage = false,
    )
}