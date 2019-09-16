package views.home

import wrapper.div
import wrapper.vComponent
import wrapper.vRender


fun home() = vComponent<Unit> {
    name = "Home"

    setup = { _, _ ->

        vRender {
            div {
                +"HOME"
            }
        }
    }
}


