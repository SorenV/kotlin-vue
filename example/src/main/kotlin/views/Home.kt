package views

import wrapper.VComponent
import wrapper.div
import wrapper.vRender


class Home : VComponent<Unit>() {
    init {
        setup { _, _ ->

            vRender {
                div {
                    +"HOME"
                }
            }
        }
    }
}


