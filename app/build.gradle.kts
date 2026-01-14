plugins {
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.ANDROID_APPLICATION)
}

android {
    namespace = BuildConfig.APPLICATION_ID
    compileSdk = BuildConfig.COMPILE_SDK

    defaultConfig {
        applicationId = BuildConfig.APPLICATION_ID
        minSdk = BuildConfig.MIN_SDK_VERSION
        targetSdk = BuildConfig.TARGET_SDK_VERSION
        versionCode = ReleaseConfig.VERSION_CODE
        versionName = ReleaseConfig.VERSION_NAME

        testInstrumentationRunner = TestBuildConfig.TEST_INSTRUMENTATION_RUNNER
    }

    signingConfigs {
        BuildSigning.Release(project).create(this)
        BuildSigning.ReleaseExternalQa(project).create(this)
        BuildSigning.Debug(project).create(this)
    }

    buildTypes {
        getByName(Build.Release.name) {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isMinifyEnabled = Build.Release.isMinifyEnabled
            isDebuggable = Build.Release.isDebuggable
            enableUnitTestCoverage = Build.Release.enableUnitTestCoverage
            versionNameSuffix = Build.Release.versionNameSuffix
            applicationIdSuffix = Build.Release.applicationIdSuffix
            signingConfig = signingConfigs.getByName(SigningTypes.RELEASE)
        }

        getByName(Build.Debug.name) {
            isMinifyEnabled = Build.Debug.isMinifyEnabled
            isDebuggable = Build.Debug.isDebuggable
            enableUnitTestCoverage = Build.Debug.enableUnitTestCoverage
            versionNameSuffix = Build.Debug.versionNameSuffix
            applicationIdSuffix = Build.Debug.applicationIdSuffix
            signingConfig = signingConfigs.getByName(SigningTypes.DEBUG)
        }

        create(Build.ReleaseExternalQa.name) {
            isMinifyEnabled = Build.ReleaseExternalQa.isMinifyEnabled
            isDebuggable = Build.ReleaseExternalQa.isDebuggable
            enableUnitTestCoverage = Build.ReleaseExternalQa.enableUnitTestCoverage
            versionNameSuffix = Build.ReleaseExternalQa.versionNameSuffix
            applicationIdSuffix = Build.ReleaseExternalQa.applicationIdSuffix
            signingConfig = signingConfigs.getByName(SigningTypes.RELEASE_EXTERNAL_QA)
        }
    }

    flavorDimensions.add(BuildDimensions.APP)
    flavorDimensions.add(BuildDimensions.STORE)

    productFlavors {
        BuildFlavor.Google.create(this)
        BuildFlavor.Huawei.create(this)
        BuildFlavor.Driver.create(this)
        BuildFlavor.Client.create(this)
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(Dependencies.ANDROIDX_CORE)
    implementation(Dependencies.ANDROIDX_LIFECYCLE_RUNTIME_KTX)
    implementation(Dependencies.ANDROIDX_ACTIVITY_COMPOSE)
    implementation(Dependencies.ANDROIDX_UI)
    implementation(Dependencies.ANDROIDX_UI_GRAPHICS)
    implementation(Dependencies.ANDROIDX_UI_TOOLING_PREVIEW)
    implementation(Dependencies.ANDROIDX_MATERIAL3)


    testImplementation(TestDependencies.ANDROIDX_JUNIT)


    androidTestImplementation(TestDependencies.ANDROIDX_JUNIT)
    androidTestImplementation(TestDependencies.ANDROIDX_ESPRESSO_CORE)
    androidTestImplementation(TestDependencies.ANDROIDX_UI_TEST_JUNIT4)

    debugImplementation(Dependencies.ANDROIDX_UI_TOOLING_PREVIEW)
    debugImplementation(TestDependencies.ANDROIDX_COMPOSE_UI_TEST_MANIFEST)
}