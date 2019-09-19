package components

import wrapper.div
import wrapper.vComponent
import wrapper.vRender

interface FunctionComponent {
    var message: String
}

fun functionComponent() = vComponent<FunctionComponent> {
    name = "FunctionComponent"

    propData {
        "message"{
            type = String::class.js
            required = true
        }
    }

    setup { p, _ ->
        vRender {
            div {
                +p.message
            }
        }
    }
}
