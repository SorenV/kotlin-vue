package components

import kotlinx.css.Color
import kotlinx.css.color
import wrapper.div
import wrapper.vComponent
import wrapper.vRender

interface FunctionComponent {
    var message: String
}

fun functionComponent() = vComponent<FunctionComponent> {
    name = "FunctionComponent"

    css {
        ".message"{
            color = Color.darkOrchid
        }
    }

    propData {
        "message"{
            type = String::class.js
            required = true
        }
    }

    setup { p, _ ->
        vRender {
            div {
                `class` = "message"
                +p.message
            }
        }
    }
}
