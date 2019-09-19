package views

import components.functionComponent
import wrapper.VComponent
import wrapper.div
import wrapper.vRender


class Home : VComponent<Unit>() {
    init {
        setup { _, _ ->

            vRender {
                div {
                    functionComponent().h {
                        props {
                            message = "Welcome to Kotlin/Vue"
                        }
                    }
                }
            }
        }
    }
}


