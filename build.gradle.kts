plugins {
    id("java")
}

group = "xyz.volartrix"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.3-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

var artifact = "build/libs/Amethyst-1.0-SNAPSHOT.jar" // Name of the artifact produced by ./gradlew build

tasks.register("copyJar") {
    group = "plugin"
    description = "Deletes the old JAR and copies the new one to the test/plugins directory."

    doLast {
        // Delete the old JAR in test/plugins if it exists
        file("test/plugins/${artifact.substringAfterLast("/")}").takeIf { it.exists() }?.delete()

        // Copy the new JAR
        exec {
            commandLine("cp", artifact, "test/plugins")
        }
    }
}

tasks.register("runServer") {
    group = "plugin"
    description = "Executes the test/run.bat script."

    doLast {
        exec {
            commandLine("cmd", "/c", "test\\run.bat")
        }
    }
}