package views.reactive_api

import external.composition_api.Ref
import external.composition_api.ref
import external.vue.Location
import kotlinext.js.jsObject
import kotlinx.css.*
import useRouter
import wrapper.*
import kotlin.js.json

private sealed class Tabs {
    object Reactive : Tabs()
    object Ref : Tabs()
}

class ReactiveApi : VComponent<Unit>() {
    init {
        css {
            ".tabs"{
                width = LinearDimension("100%")
                display = Display.flex
            }

            ".tab"{
                padding = "0.125rem"
                margin = "0 0.125rem"
                backgroundColor = Color.lightGray
            }

            ".tab.active"{
                backgroundColor = Color.grey
            }

            hover(".tab") {
                backgroundColor = Color.grey
            }
        }

        setup { _, _ ->

            val router = useRouter()

            val activeTab: Ref<Tabs?> = ref(null)

            val isActiveTab: (tab: Tabs) -> Boolean = { it === activeTab.value }


            vRender {
                div {
                    div {
                        `class` = "tabs"
                        div {
                            +"Reactive"
                            `class` = arrayOf("tab", json("active" to isActiveTab(Tabs.Reactive)))

                            on {
                                click {
                                    router.push(jsObject<Location> { name = "reactive" })
                                    activeTab.value = Tabs.Reactive
                                }
                            }
                        }
                        div {
                            +"Ref"
                            `class` = arrayOf("tab", json("active" to isActiveTab(Tabs.Ref)))

                            on {
                                click {
                                    router.push(jsObject<Location> { name = "ref" })
                                    activeTab.value = Tabs.Ref
                                }
                            }
                        }
                    }
                    console.log(
                        keepAlive {
                            props {
                                include = "Reactive"
                            }
                            routerView()
                        })
                }
            }
        }
    }
}


