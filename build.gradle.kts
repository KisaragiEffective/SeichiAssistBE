import java.net.URI
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    java
    maven
    kotlin("jvm").version("1.3.70")
}

group = "com.github.unchama"
version = "1.0.0"

val embed: Configuration by configurations.creating

configurations.implementation { extendsFrom(embed) }

project.sourceSets {
    getByName("main") { java.srcDir("src/main/java") }
    getByName("test") { java.srcDir("src/test/java") }
}

repositories {
    maven { url = URI("http://repo.nukkitx.com/main/") }
    mavenCentral()
}

dependencies {
    implementation("cn.nukkit:nukkit:1.0-SNAPSHOT")
    embed(kotlin("stdlib-jdk8"))
}

tasks.withType(JavaCompile::class.java).all {
    this.options.encoding = "UTF-8"
}

tasks.processResources {
    filteringCharset = "UTF-8"
    from(sourceSets.main.get().resources.srcDirs) {
        include("**")

        val tokenReplacementMap = mapOf(
                "version" to project.version,
                "name" to project.rootProject.name
        )

        filter<ReplaceTokens>("tokens" to tokenReplacementMap)
    }
    from(projectDir) { include("LICENSE") }
}

val compilerArgument = listOf("-Xlint:unchecked", "-Xlint:deprecation")
val kotlinCompilerArgument = listOf("-Xjsr305=strict")

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
    freeCompilerArgs = compilerArgument + kotlinCompilerArgument
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
    freeCompilerArgs = compilerArgument + kotlinCompilerArgument
}

