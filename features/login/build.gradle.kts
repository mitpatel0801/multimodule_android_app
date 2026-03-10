import dependency.androidx
import dependency.dataModule
import dependency.hilt
import dependency.retrofit
import dependency.room
import dependency.testDebugDeps
import dependency.testDeps
import dependency.testImplDeps
import plugs.SharedLibraryGradlePlugin

plugins {
  id(plugs.BuildPlugins.ANDROID_LIBRARY)
}

apply<SharedLibraryGradlePlugin>()

android {
  namespace = "com.example.login"
}

dependencies {

  androidx()
    retrofit()
    dataModule()
  hilt()
  room()
  testDeps()
  testImplDeps()
  testDebugDeps()
}
