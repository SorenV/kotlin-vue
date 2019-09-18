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

fun reactiveApi() = vComponent<Unit> {

    name = "ReactiveApi"

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

        hover(".tab") {
            backgroundColor = Color.grey
        }
    }

    setup = { _, _ ->

        val router = useRouter()

        val activeTab: Ref<Tabs> = ref(Tabs.Reactive)

        vRender {
            div {
                div {
                    `class` = "tabs"

                    tab("Reactive", Tabs.Ref, activeTab) { router.push(jsObject<Location> { name = "reactive" }) }
                    tab("Ref", Tabs.Ref, activeTab) { router.push(jsObject<Location> { name = "ref" }) }
                }
                routerView()
            }
        }
    }
}


private fun VRender<*, *, *>.tab(name: String, tab: Tabs, activeTab: Ref<Tabs>, routerCallBack: () -> Unit) =
    div {
        +name
        `class` = arrayOf("tab", json("active-tab" to { tab === activeTab.value }))

        on {
            click {
                activeTab.value = tab
                routerCallBack()
            }
        }
    }
