import org.gradle.api.Plugin
import org.gradle.api.Project

import org.gradle.kotlin.dsl.*
import java.io.File

open class KotlinUserscriptPluginExtension {
    var name: String? = null
}

class KotlinUserscriptPlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = project.run {
        val extension = project.extensions.create<KotlinUserscriptPluginExtension>("userscript")
        tasks {
            register("generateUserscript") {
                group = "other"
                description = "Adds a preamble needed by plugins like Tampermonkey, adds a proper file extension, and other."
                dependsOn("browserWebpack")
                doLast {
                    val pathToInputBundledJavascriptFile = "build/distributions/${project.name}.js"
                    val pathToOutputUserscriptFile = "build/distributions/${project.name}.user.js"

                    val userscriptPreamble = """
                        // ==UserScript==
                        ${userscriptProperty("name", extension.name ?: project.name)}
                        // @namespace    http://tampermonkey.net/
                        ${userscriptProperty("version", project.version.toString())}
                        // @description  try to take over the world!
                        // @author       You
                        // @match        https://www.google.pl/
                        // @grant        none
                        // ==/UserScript==
                        
                        
                    """.trimIndent()

                    val bundledJavascript = File(pathToInputBundledJavascriptFile).readText()
                    File(pathToOutputUserscriptFile).writeText(userscriptPreamble + bundledJavascript)
                }
            }
        }
    }

    private fun userscriptProperty(name: String, value: String) =
        "// @$name $value"
}
