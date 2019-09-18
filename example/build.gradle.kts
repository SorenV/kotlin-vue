val kotlinVersion = "1.3.50"
val coroutinesVersion = "1.3.1"
val kotlinExtensionsVersion =
    "1.0.1-pre.83-kotlin-1.3.41" //https://bintray.com/kotlin/kotlin-js-wrappers/kotlin-extensions
val serializationVersion = "0.11.1"


plugins {
    kotlin("js")
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
            runTask {
                sourceMaps = true
                saveEvaluatedConfigFile = true
                devServer = devServer!!.copy(
                    open = false,
                    port = 8083
                )
            }
        }
        sourceSets {
            main {
                dependencies {
                    implementation(npm("core-js", "latest"))
                    implementation(npm("vue", "latest"))
                    implementation(npm("vue-router", "latest"))
                    implementation(npm("@vue/composition-api", "latest"))
                    implementation(npm("@fortawesome/fontawesome-svg-core", "latest"))
                    implementation(npm("@fortawesome/free-solid-svg-icons", "latest"))
                    implementation(npm("@fortawesome/vue-fontawesome", "latest"))
                    implementation(project(":"))
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$coroutinesVersion")
                    implementation("org.jetbrains:kotlin-extensions:$kotlinExtensionsVersion")
                    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serializationVersion")
                    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion")
                    implementation("org.jetbrains:kotlin-css:1.0.0-pre.83-kotlin-1.3.50")
                    implementation("org.jetbrains:kotlin-css-js:1.0.0-pre.83-kotlin-1.3.50")
                }
            }
            test {
                dependencies {
                    implementation(kotlin("test-js"))
                }
            }
        }
    }
}

