val kotlinVersion = "1.3.50"
val kotlinExtensionsVersion =
    "1.0.1-pre.83-kotlin-1.3.50" //https://bintray.com/kotlin/kotlin-js-wrappers/kotlin-extensions

plugins {
    val kotlinVersion = "1.3.50"
    kotlin("js") version kotlinVersion
}

group = "kotlin-wrapper"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    maven(url = "https://dl.bintray.com/kotlin/kotlin-dev")
    maven(url = "https://dl.bintray.com/kotlinx/kotlinx")
    maven(url = "https://dl.bintray.com/kotlin/kotlin-js-wrappers")
}


kotlin {
    target {
        browser {
            val main by compilations.getting {
                kotlinOptions {
                    sourceMap = true
                    moduleKind = "commonjs"
                    sourceMapEmbedSources = "always"
                }
            }
        }
        sourceSets {
            main {
                dependencies {
                    implementation(npm("core-js", "latest"))
                    implementation(npm("@jetbrains/kotlin-css", "latest"))
                    implementation(npm("@jetbrains/kotlin-css-js", "latest"))
                    implementation(npm("@jetbrains/kotlin-extensions", "latest"))
                    implementation("org.jetbrains:kotlin-extensions:$kotlinExtensionsVersion")
                    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion")
                    implementation("org.jetbrains:kotlin-css:1.0.0-pre.83-kotlin-1.3.50")
                    implementation("org.jetbrains:kotlin-css-js:1.0.0-pre.83-kotlin-1.3.50")
                    implementation("org.jetbrains.kotlinx:kotlinx-html:0.6.12")
                }
            }
        }
    }
}
