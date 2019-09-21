package views.functional_compnents

import wrapper.VComponent
import wrapper.div
import wrapper.vRender

class FunctionalComponents : VComponent<Unit>() {
    init {
        setup { _, _ ->

            vRender {
                div {
                    +HelloWorld {
                        props {
                            message = "Hello World!"
                        }
                    }
                }
            }
        }
    }
}

