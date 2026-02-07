import SharedPlugins.SharedLibraryGradlePlugin
import dependency.*

plugins {
    id(dependency.BuildPlugins.ANDROID_LIBRARY)
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