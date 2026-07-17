import com.mmodding.gradle.api.EnvironmentTarget

plugins {
    id("maven-publish")
    alias(libs.plugins.fabric.loom)
    alias(libs.plugins.mod.publish)
    alias(libs.plugins.mmodding.gradle)
}

version = "${project.property("mod_version")}+${libs.versions.minecraft.get()}"
group = project.property("maven_group") as String

base {
    archivesName = project.property("archives_base_name") as String
}

repositories {
    mavenCentral()
    maven {
        name = "MModding"
        url = uri("https://maven.mmodding.com/releases")
    }
}

dependencies {
    minecraft(libs.minecraft)
    implementation(libs.fabric.loader)

    implementation(libs.mmodding)
    implementation(libs.fabric.api)
}

fabricApi {
    configureDataGeneration {
        client = true
    }
}

mmodding {
	configureFabricModJson {
		name = "Archeon"
		namespace = "archeon"
		group = "com.mmodding"
		description = "This is the Official Version of Archeon. Archeon is a brand new dimension, full of new blocks, mobs and more! All you need to get there is a portal made of Mysterious Stone, filled with a magical energy made by the Wand of Nature!"
		icon = "assets/archeon/icon.png"
		addAuthor("MModding Team")
		addContributor("Aethyus (Author, Art Director, Project Manager)")
		addContributor("Aeramisu (Art Director, Project Manager, Composer, Concept Artist, Sound Designer)")
		addContributor("FirstMegaGame4 (Lead Developer, Project Manager)")
		addContributor("Chatoine (Modeler)")
		addContributor("Contributors [Aerod (Additional Art); Tim Tim Rurkowski (Composer); Rotch Gwylt (Composer); Scarecrowman (Composer)]")
		addContributor("Past [Aethyus (as Former Forge Version Developer trough MCreator); Mystoxi (Help on MCreator); Tenkite (Old Additional Art)]")
		withContact {
			homepage = "https://mmodding.com"
			sources = "https://github.com/MModding/archeon"
			issues = "https://github.com/MModding/archeon/issues"
		}
		environment = EnvironmentTarget.ANY
		withEntrypoints {
			init("com.mmodding.archeon.Archeon")
			client("com.mmodding.archeon.client.ArcheonClient")
			custom("mmodding_bootstrap_init", "com.mmodding.archeon.bootstrap.ArcheonBootstrap")
		}
		addMixin("archeon.mixins.json")
		withDependencies {
			javaVersion = ">=" + 17
			minecraftVersion = "~" + libs.versions.minecraft.get()
			fabricLoaderVersion = ">=" + libs.versions.fabric.loader.get()
			fabricApiVersion = ">=" + libs.versions.fabric.api.get()
			addDependency("mmodding_lib", ">=" + libs.versions.mmodding.get() + "-")
			mmoddingLibraryVersion = ">=" + libs.versions.mmodding.get()
		}
		withCustom {
			put("fluidlogged", "archeon.fluidlogged.json")
		}
        loomModRegistration()
	}
}

tasks.named<ProcessResources>("processResources") {
    inputs.property("version", version)

    filesMatching("fabric.mod.json") {
        expand("version" to version)
    }
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
    // Minecraft 26.1 upwards uses Java 25.
    options.release = libs.versions.java.get().toInt()
}

java {
    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
    // if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

setOf(tasks.named<Jar>("jar").get(), tasks.named<Jar>("sourcesJar").get()).forEach { jarTask ->
    jarTask.inputs.property("archivesName", project.name)

    for (licenseFilePath in setOf("LICENSE", "LICENSE.md")) {
        jarTask.from(licenseFilePath) {
            rename { "${licenseFilePath}_${project.name}"}
        }
    }
}

// Configuring Maven Publications
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    repositories {
        if (providers.environmentVariable("MAVEN_USERNAME").isPresent) {
            maven {
                name = "MModding"
                url = uri("https://maven.mmodding.com/releases")
                credentials {
                    username = providers.environmentVariable("MAVEN_USERNAME").get()
                    password = providers.environmentVariable("MAVEN_PASSWORD").get()
                }
            }
        }
    }
}

fun extractSupportedVersions() : List<String> {
    var mcVer = libs.versions.minecraft.get()
    if (mcVer.contains("snapshot")) {
        return listOf(mcVer)
    }
    else {
        // published artifacts on these versions should also cover the proper Minecraft release correctly
        if (mcVer.contains("-pre")) mcVer = mcVer.split("-pre").first()
        if (mcVer.contains("-rc")) mcVer = mcVer.split("-rc").first()
        val versionComponents = mcVer.split(".")
        if (versionComponents.size == 2) {
            return listOf(mcVer)
        }
        else {
            val lastComponent = versionComponents.last().toInt()
            val versionBase = versionComponents.subList(0, 1).joinToString(".")
            val versions = mutableListOf(versionBase)
            for (i in 1..lastComponent) {
                versions.add("$versionBase.$i")
            }
            return versions
        }
    }
}

// Configures the mod publication
publishMods {
    if (providers.environmentVariable("CHANGELOG").isPresent) {
        displayName = "${property("mod_name")} ${project.version}"
        changelog.set(providers.environmentVariable("CHANGELOG").get())

        val title = providers.environmentVariable("TITLE").get()
        if (title.contains("alpha")) {
            type.set(ALPHA)
        }
        else if (title.contains("beta")) {
            type.set(BETA)
        }
        else {
            type.set(STABLE)
        }

        file.set(tasks.named<Jar>("jar").get().archiveFile)
        additionalFiles.from(tasks.named<Jar>("sourcesJar").get().archiveFile)

        modLoaders.add("fabric")
        modLoaders.add("quilt")

        modrinth {
            projectId = project.property("modrinth_project") as String
            accessToken = providers.environmentVariable("MODRINTH_TOKEN").get()

            minecraftVersions = extractSupportedVersions()

            projectDescription = providers.fileContents(layout.projectDirectory.file("README.md")).asText

            requires("fabric-api")
            requires("mmodding-library")
        }

        curseforge {
            projectId = project.property("curseforge_project") as String
            accessToken = providers.environmentVariable("CURSEFORGE_TOKEN").get()

            javaVersions.add(JavaVersion.entries.first { v -> v.name == "VERSION_" + libs.versions.java.get() })

            minecraftVersions = extractSupportedVersions()

            client = true
            server = true

            changelogType = "markdown"

            requires("fabric-api")
            requires("mmodding-library")
        }
    }
}
