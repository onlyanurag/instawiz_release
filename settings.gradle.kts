import org.gradle.process.ExecResult
import org.gradle.api.tasks.Exec
import org.gradle.api.DefaultTask
import java.io.ByteArrayOutputStream
import java.io.File
import groovy.json.JsonSlurper

rootProject.name = "Instawiz"

fun getGitCommitHash(): String {
    val output = ByteArrayOutputStream()
    exec {
        commandLine("git", "rev-parse", "--short", "HEAD")
        standardOutput = output
    }
    return output.toString().trim()
}

val configFile = File(rootDir, "config/ifl_config.json")
val fallbackConfigFile = File(rootDir, "config/example.ifl_config.json")

val jsonData: Map<*, *> = if (configFile.exists()) {
    JsonSlurper().parse(configFile) as Map<*, *>
} else {
    println("Warning: ifl_config.json not found, using example.ifl_config.json instead.")
    JsonSlurper().parse(fallbackConfigFile) as Map<*, *>
}

println("Loaded & exported Instawiz project configuration file")

gradle.rootProject {
    extra["commitHash"] = getGitCommitHash()
    extra["instawizConfig"] = jsonData
}

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}


rootDir.listFiles()
    .filter { it.isDirectory && it.name.startsWith("instawiz") && File(it, "build.gradle.kts").exists() }
    .forEach {
        include(it.name)
    }
