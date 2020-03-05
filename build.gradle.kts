import java.net.URI

plugins {
    java
    maven
    kotlin("jvm").version("1.3.70")
}

group = "com.unchama"
version = "1.0.0"

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
}

tasks.withType(JavaCompile::class.java).all {
    this.options.encoding = "UTF-8"
}
