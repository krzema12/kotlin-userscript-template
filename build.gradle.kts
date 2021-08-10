plugins {
    kotlin("js") version "1.5.21"
    `kotlin-userscript`
}

group = "it.krzeminski"
version = "1.0-SNAPSHOT"
description = "Gradle project's description"

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    js {
        browser()
    }
}

userscript {
    name = "Kotlin userscript test"
    match("https://www.example.com/*", "http://*.example.com/*")
}
