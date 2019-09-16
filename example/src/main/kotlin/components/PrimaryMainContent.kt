package components

import wrapper.*

fun primaryMainContent() = vComponent<Unit> {
    name = "PrimaryMainContent"

    css { +stylesPrimaryMainContent }

    setup = { _, _ ->
        vRender {
            div {
                `class` = "main-content"
                routerView {
                    name = "home"
                }
            }
        }
    }
}


private val stylesPrimaryMainContent: VCssRuleSet = {

    ".main-content"{
    }
}
