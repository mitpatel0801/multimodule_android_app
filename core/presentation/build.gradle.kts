import dependency.testDebugDeps
import dependency.testDeps
import dependency.testImplDeps
import plugs.SharedLibraryGradlePlugin

plugins {
    id(plugs.BuildPlugins.ANDROID_LIBRARY)
}

apply<SharedLibraryGradlePlugin>()

android {
    namespace = "com.mit.presentation"
}

dependencies {

    testDeps()
    testImplDeps()
    testDebugDeps()
}
