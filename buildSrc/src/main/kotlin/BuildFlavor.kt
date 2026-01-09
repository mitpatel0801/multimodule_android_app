import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.LibraryProductFlavor
import org.gradle.api.NamedDomainObjectContainer

sealed class BuildFlavor(
    private val name: String,
    private val dimension: String,
) {
    //Centralized logic for Application Modules
    fun create(container: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor {
        return container.create(name) {
            dimension = this@BuildFlavor.dimension
            applicationIdSuffix = ".$name"
            versionNameSuffix = "-$name"
        }
    }

    //Centralized logic for Library Modules
    fun createLibrary(container: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
        return container.create(name) {
            dimension = this@BuildFlavor.dimension
        }
    }

    object Google : BuildFlavor("google", BuildDimensions.STORE)
    object Huawei : BuildFlavor("huawei", BuildDimensions.STORE)
    object Driver : BuildFlavor("driver", BuildDimensions.APP)
    object Client : BuildFlavor("client", BuildDimensions.APP)
}

object BuildDimensions {
    const val APP = "app"
    const val STORE = "store"
}