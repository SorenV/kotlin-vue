package views


import components.primaryHeader
import components.primaryMainContent
import components.primarySideMenu
import wrapper.div
import wrapper.vComponent
import wrapper.vRender

fun primaryView() = vComponent<Unit> {
    name = "PrimaryView"
    setup = { _, _ ->
        vRender {
            div {
                `class` = "main-grid"
                primaryHeader().h()
                primarySideMenu().h()
                primaryMainContent().h()
            }
        }
    }
}
