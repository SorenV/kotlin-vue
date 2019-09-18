package views


import components.Content
import components.Header
import components.SideMenu
import wrapper.VComponent
import wrapper.div
import wrapper.vRender

class Container : VComponent<Unit>() {
    init {
        setup { _, _ ->
            vRender {
                div {
                    `class` = "main-grid"
                    +Header()
                    +SideMenu()
                    +Content()
                }
            }
        }
    }
}
