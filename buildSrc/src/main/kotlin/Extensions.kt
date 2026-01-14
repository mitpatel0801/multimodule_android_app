import org.gradle.api.Project
import java.util.Properties

const val LOCAL_PROPERTIES_FILE_NAME = "dev_credentials.properties"

fun Project.getLocalProperties(propertyName: String): String {

    val localProperties = Properties().apply {
        val localPropertyFile = project.rootProject.file(LOCAL_PROPERTIES_FILE_NAME)
        if (localPropertyFile.exists()) {
            load(localPropertyFile.inputStream())
        }
    }

    return localProperties.getProperty(propertyName)
}
