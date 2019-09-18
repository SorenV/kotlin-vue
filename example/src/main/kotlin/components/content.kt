package components

import wrapper.*

fun content() = vComponent<Unit> {
    name = "PrimaryMainContent"

    css { +stylesPrimaryMainContent }

    setup = { _, _ ->
        vRender {
            div {
                `class` = "main-content"
                routerView()
            }
        }
    }
}


private val stylesPrimaryMainContent: VCssRuleSet = {

    ".main-content"{
    }
}
