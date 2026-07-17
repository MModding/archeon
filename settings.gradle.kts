pluginManagement {
    repositories {
        maven {
            name = "MModding"
            url = uri("https://maven.mmodding.com/releases")
        }
        maven {
            name = "QuiltMC"
            url = uri("https://maven.quiltmc.org/repository/release")
        }
        maven {
            name = "FabricMC"
            url = uri("https://maven.fabricmc.net")
        }
        gradlePluginPortal()
    }
}
