import dependency.*

plugins {
    id(dependency.BuildPlugins.ANDROID_LIBRARY)
    id(dependency.BuildPlugins.KOTLIN_ANDROID)
    kotlin(dependency.BuildPlugins.KAPT)
}

android {
    namespace = "com.example.login"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    androidx()
    hilt()
    room()
    testDeps()
    testImplDeps()
    testDebugDeps()
}