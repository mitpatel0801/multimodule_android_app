import com.android.build.api.dsl.ApkSigningConfig
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import java.io.File

sealed class BuildSigning(val name: String) {

    abstract fun create(container: NamedDomainObjectContainer<out ApkSigningConfig>)

    class Debug(private val project: Project) : BuildSigning(SigningTypes.DEBUG) {
        override fun create(container: NamedDomainObjectContainer<out ApkSigningConfig>) {
            container.getByName(name) {
                // Debug usually uses the standard android debug key
                storeFile = project.rootProject.file("debug.keystore")
                storePassword = "android"
                keyAlias = "androiddebugkey"
                keyPassword = "android"
                enableV1Signing = true
                enableV2Signing = true
            }
        }
    }

    class Release(private val project: Project) : BuildSigning(SigningTypes.RELEASE) {
        override fun create(container: NamedDomainObjectContainer<out ApkSigningConfig>) {
            container.create(name) {
                storeFile = File(project.getLocalProperty("release_key.store"))
                storePassword = project.getLocalProperty("release_store.password")
                keyAlias = project.getLocalProperty("release_key.alias")
                keyPassword = project.getLocalProperty("release_key.password")

                enableV1Signing = true
                enableV2Signing = true
            }
        }
    }

    class ReleaseExternalQa(private val project: Project) : BuildSigning(SigningTypes.RELEASE_EXTERNAL_QA) {
        override fun create(container: NamedDomainObjectContainer<out ApkSigningConfig>) {
            container.create(name) {
                // UPDATED: Now matches the qa_ prefix in your properties file
                storeFile = File(project.getLocalProperty("qa_key.store"))
                storePassword = project.getLocalProperty("qa_store.password")
                keyAlias = project.getLocalProperty("qa_key.alias")
                keyPassword = project.getLocalProperty("qa_key.password")

                enableV1Signing = true
                enableV2Signing = true
            }
        }
    }
}

object SigningTypes {
    const val DEBUG = "debug"
    const val RELEASE = "release"
    const val RELEASE_EXTERNAL_QA = "releaseExternalQa"
}