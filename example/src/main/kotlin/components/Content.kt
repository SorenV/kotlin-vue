package components

import wrapper.*


class Content : VComponent<Unit>() {
    init {

        css { +stylesPrimaryMainContent }

        setup { _, _ ->
            vRender {
                div {
                    `class` = "main-content"
                    routerView()
                }
            }
        }
    }
}


private val stylesPrimaryMainContent: VCssRuleSet = {

    ".main-content"{
    }
}
