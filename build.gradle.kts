import java.net.URI

plugins {
    java
    kotlin("jvm").version("1.3.70")
}

group = "com.github.unchama"
version = "1.0.0"

repositories {
    maven { url = URI("http://repo.nukkitx.com/main/") }
    mavenCentral()
}

dependencies {
    implementation("cn.nukkit:nukkit:1.0-SNAPSHOT")
    compile(kotlin("stdlib-jdk8"))
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
    }

    withType<Jar> {
        from(configurations.getByName("compile").map { if (it.isDirectory) it else zipTree(it) })
    }
}
