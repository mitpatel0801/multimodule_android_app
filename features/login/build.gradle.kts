import dependency.androidx
import dependency.hilt
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
    hilt()
    room()
    testDeps()
    testImplDeps()
    testDebugDeps()
}
