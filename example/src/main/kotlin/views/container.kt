package views


import components.content
import components.header
import components.sideMenu
import wrapper.div
import wrapper.vComponent
import wrapper.vRender

fun container() = vComponent<Unit> {
    name = "PrimaryView"
    setup = { _, _ ->
        vRender {
            div {
                `class` = "main-grid"
                header().h()
                sideMenu().h()
                content().h()
            }
        }
    }
}
