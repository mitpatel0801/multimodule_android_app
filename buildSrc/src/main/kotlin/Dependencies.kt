object DependenciesVersions {

    const val CORE_KTX = "1.10.1"
    const val LIFE_CYCLE_RUNTIME_KTX = "2.6.1"
    const val KOTLIN = "1.9.0"
    const val JUNIT = "4.13.2"
    const val JUNIT_VERSION = "1.1.5"
    const val ESPRESSO_CORE = "3.5.1"
    const val ACTIVITY_COMPOSE = "1.8.0"
    const val COMPOSE_UI = "1.6.8"
    const val MATERIAL_3 = "1.2.1"

}

object Dependencies {
    const val ANDROIDX_CORE = "androidx.core:core-ktx:${DependenciesVersions.CORE_KTX}"
    const val ANDROIDX_LIFECYCLE_RUNTIME_KTX =
        "androidx.lifecycle:lifecycle-runtime-ktx:${DependenciesVersions.LIFE_CYCLE_RUNTIME_KTX}"
    const val ANDROIDX_ACTIVITY_COMPOSE =
        "androidx.activity:activity-compose:${DependenciesVersions.ACTIVITY_COMPOSE}"
    const val ANDROIDX_UI = "androidx.compose.ui:ui:${DependenciesVersions.COMPOSE_UI}"
    const val ANDROIDX_UI_GRAPHICS = "androidx.compose.ui:ui-graphics:${DependenciesVersions.COMPOSE_UI}"
    const val ANDROIDX_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${DependenciesVersions.COMPOSE_UI}"
    const val ANDROIDX_MATERIAL3= "androidx.compose.material3:material3:${DependenciesVersions.MATERIAL_3}"
}


object TestDependencies {
    const val ANDROIDX_JUNIT = "androidx.test.ext:junit:${DependenciesVersions.JUNIT}"
    const val ANDROIDX_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${DependenciesVersions.ESPRESSO_CORE}"
    const val ANDROIDX_UI_TEST_JUNIT4 = "androidx.compose.ui:ui-test-junit4:${DependenciesVersions.JUNIT_VERSION}"
    const val ANDROIDX_COMPOSE_UI_TEST_MANIFEST ="androidx.compose.ui:ui-test-manifest:${DependenciesVersions.COMPOSE_UI}"
}