package components

import kotlinx.css.Align
import kotlinx.css.Display
import kotlinx.css.alignItems
import kotlinx.css.display
import wrapper.VComponent
import wrapper.div
import wrapper.vRender

class Header : VComponent<Unit>() {
    init {
        css {
            ".header" {
                display = Display.flex
                alignItems = Align.center
            }
        }

        setup { _, _ ->
            vRender {
                div {
                    `class` = "header"
                    +"HEADER"
                }
            }
        }
    }
}

