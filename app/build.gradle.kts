import build.BuildCreator
import build.BuildDimensions
import build.BuildFlavor
import dependency.DependenciesVersions
import dependency.androidx
import dependency.hilt
import dependency.loginModule
import dependency.okHttp
import dependency.retrofit
import dependency.room
import dependency.testDebugDeps
import dependency.testDeps
import dependency.testImplDeps

plugins {
  id(plugs.BuildPlugins.KOTLIN_ANDROID)
  id(plugs.BuildPlugins.ANDROID_APPLICATION)
  id(plugs.BuildPlugins.ANDROID)
  id(plugs.BuildPlugins.KAPT)
  id(plugs.BuildPlugins.KTLINT)
  id(plugs.BuildPlugins.SPOTLESS)
  id(plugs.BuildPlugins.DETEKT)
  id(plugs.BuildPlugins.UPDATE_DEPS_VERSIONS)
  id(plugs.BuildPlugins.DOKKA)
  id(plugs.BuildPlugins.HILT) version dependency.DependenciesVersions.HILT
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
    BuildCreator.Release(project).create(this).apply {
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro",
      )
      signingConfig = signingConfigs.getByName(SigningTypes.RELEASE)
    }

    BuildCreator.Debug(project).create(this).apply {
      signingConfig = signingConfigs.getByName(SigningTypes.DEBUG)
    }

    BuildCreator.ReleaseExternalQa(project).create(this).apply {
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
    buildConfig = true
  }
}

dependencies {

  loginModule()
  androidx()
  hilt()
  room()
  okHttp()
  retrofit()
  testDeps()
  testImplDeps()
  testDebugDeps()
}
