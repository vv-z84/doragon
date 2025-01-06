plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.skubawa.doragon.watcher"
version = "1.0-SNAPSHOT"
val ktor_version: String by project
val logback_version: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}