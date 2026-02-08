package dependency

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

    const val RETROFIT = "2.11.0"
    const val RETROFIT_COROUTINE_ADAPTER_VERSION = "0.9.2"
    const val OKHTTP = "5.0.0-alpha.2"
    const val HILT = "2.44"
    const val HILT_COMPOSE = "1.2.0"
    const val ROOM = "2.6.1"
    const val WORK_MANAGER = "2.8.1"

}

object Dependencies {
    const val ANDROIDX_CORE = "androidx.core:core-ktx:${DependenciesVersions.CORE_KTX}"
    const val ANDROIDX_LIFECYCLE_RUNTIME_KTX =
        "androidx.lifecycle:lifecycle-runtime-ktx:${DependenciesVersions.LIFE_CYCLE_RUNTIME_KTX}"
    const val ANDROIDX_ACTIVITY_COMPOSE =
        "androidx.activity:activity-compose:${DependenciesVersions.ACTIVITY_COMPOSE}"
    const val ANDROIDX_UI = "androidx.compose.ui:ui:${DependenciesVersions.COMPOSE_UI}"
    const val ANDROIDX_UI_GRAPHICS =
        "androidx.compose.ui:ui-graphics:${DependenciesVersions.COMPOSE_UI}"
    const val ANDROIDX_UI_TOOLING_PREVIEW =
        "androidx.compose.ui:ui-tooling-preview:${DependenciesVersions.COMPOSE_UI}"
    const val ANDROIDX_MATERIAL3 =
        "androidx.compose.material3:material3:${DependenciesVersions.MATERIAL_3}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${DependenciesVersions.HILT}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${DependenciesVersions.HILT}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${DependenciesVersions.HILT}"
    const val hiltCompose = "androidx.hilt:hilt-work:${DependenciesVersions.HILT_COMPOSE}"
    const val hiltCompilerKapt = "androidx.hilt:hilt-compiler:${DependenciesVersions.HILT_COMPOSE}"
    const val hiltNavigation =
        "androidx.hilt:hilt-navigation-compose:${DependenciesVersions.HILT_COMPOSE}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${DependenciesVersions.RETROFIT}"
    const val retrofitConverterGson =
        "com.squareup.retrofit2:converter-gson:${DependenciesVersions.RETROFIT}"
    const val retrofitKotlinCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${DependenciesVersions.RETROFIT_COROUTINE_ADAPTER_VERSION}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${DependenciesVersions.OKHTTP}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${DependenciesVersions.OKHTTP}"

    const val roomRuntime = "androidx.room:room-runtime:${DependenciesVersions.ROOM}"
    const val roomCompiler = "androidx.room:room-compiler:${DependenciesVersions.ROOM}"
    const val roomKtx = "androidx.room:room-ktx:${DependenciesVersions.ROOM}"
    const val workManager = "androidx.work:work-runtime-ktx:${DependenciesVersions.WORK_MANAGER}"
}


object TestDependencies {
    const val ANDROIDX_JUNIT = "androidx.test.ext:junit:${DependenciesVersions.JUNIT_VERSION}"
    const val ANDROIDX_ESPRESSO_CORE =
        "androidx.test.espresso:espresso-core:${DependenciesVersions.ESPRESSO_CORE}"
    const val ANDROIDX_COMPOSE_UI_TEST =
        "androidx.compose.ui:ui-test-junit4:${DependenciesVersions.COMPOSE_UI}"
    const val ANDROIDX_COMPOSE_UI_TEST_MANIFEST =
        "androidx.compose.ui:ui-test-manifest:${DependenciesVersions.COMPOSE_UI}"
}