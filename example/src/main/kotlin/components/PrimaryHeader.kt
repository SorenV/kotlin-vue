package components

import kotlinx.css.Align
import kotlinx.css.Display
import kotlinx.css.alignItems
import kotlinx.css.display
import wrapper.div
import wrapper.vComponent
import wrapper.vRender

fun primaryHeader() = vComponent<Unit> {
    name = "PrimaryHeader"

    css {
        ".header" {
            display = Display.flex
            alignItems = Align.center
        }
    }

    setup = { _, _ ->
        vRender {
            div {
                `class` = "header"
                +"HEADER"
            }
        }
    }
}

