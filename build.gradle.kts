plugins {
    kotlin("js") version "1.3.61"
    `kotlin-userscript`
}

group = "it.krzeminski"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js")
    testImplementation("org.jetbrains.kotlin:kotlin-test-js")
}

kotlin.target.browser { }

userscript {
    name = "Kotlin userscript test"
}
