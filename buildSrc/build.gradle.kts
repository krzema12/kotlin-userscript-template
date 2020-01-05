plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("kotlin-userscript-plugin") {
            id = "kotlin-userscript"
            implementationClass = "KotlinUserscriptPlugin"
        }
    }
}

repositories {
    jcenter()
}
