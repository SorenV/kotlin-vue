package components.side_menu

import external.font_awsome.FaIcon
import kotlinext.js.Object
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import wrapper.*
import kotlin.js.Json

class SideMenuItemProps {

    var icon: Any? = null

    fun icon(name: String) {
        icon = name
    }

    fun icon(obj: Json) {
        icon = obj
    }

    fun icon(array: Array<String>) {
        icon = array
    }

    var title: String = ""

    var to: String? = null
}

class SideMenuItem(builder: VComponentBuilder<SideMenuItemProps>) :
    VComponent<SideMenuItemProps>(builder, SideMenuItemProps()) {
    init {
        css { +stylesSideMenuItem }

        propData {
            "icon" {
                type = arrayOf(String::class.js, Object::class.js, Array<String>::class.js)
                default = "icons"
            }
            "title"{
                type = String::class.js
                required = true
            }
            "to"{
                type = String::class.js
                default = "home"
            }
        }

        setup { p, _ ->

            vRender {
                div {
                    `class` = "menu-item"
                    div {
                        `class` = "icon fa-fw"

                        h(FaIcon) {
                            props {
                                p.icon?.let { icon = it }
                            }
                        }
                    }

                    routerLink {
                        props {
                            to {
                                name = p.to
                            }
                        }
                        +p.title
                    }
                }
            }
        }
    }
}

private val stylesSideMenuItem: VCssRuleSet = {
    ".menu-item"{
        display = Display.flex
        alignItems = Align.center
        height = LinearDimension("3rem")
        backgroundColor = Color("#F4F4F5")
    }

    ".icon" {
        color = Color("#1D457C")
        margin = "0.35rem"
    }

    a {
        color = Color("#414141")
        textDecoration = TextDecoration.none
    }

    hover(".menu-item") {
        backgroundColor = Color("#D7D7D7")
        cursor = Cursor.pointer
    }

}
