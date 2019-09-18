package components

import components.side_menu.sideMenuGroup
import components.side_menu.sideMenuItem
import kotlinx.css.Align
import kotlinx.css.Display
import kotlinx.css.alignItems
import kotlinx.css.display
import wrapper.VCssRuleSet
import wrapper.div
import wrapper.vComponent
import wrapper.vRender

fun sideMenu() = vComponent<Unit> {
    name = "PrimarySideMenu"

    css { +stylesSideMenu }

    setup = { _, _ ->
        vRender {
            div {
                `class` = "side-menu"
                sideMenuItem().h {
                    props {
                        to = "home"
                        title = "Home"
                        icon = "home"
                    }
                }
                sideMenuItem().h {
                    props {
                        to = "directives"
                        title = "Directives"
                        icon = "terminal"
                    }
                }
                sideMenuItem().h {
                    props {
                        to = "reactiveApi"
                        title = "Reactive API"
                        icon = "cogs"
                    }
                }
                sideMenuGroup().h {
                    props {
                        title = "Slots"
                        icon = "grip-lines"
                    }
                    div {
                        slot = "side-menu-items"
                        sideMenuItem().h {
                            props {
                                to = "slots"
                                title = "Slots"
                                icon(arrayOf("fa", "grip-lines"))
                            }
                        }
                        sideMenuItem().h {
                            props {
                                to = "scopedSlots"
                                title = "Scoped Slots"
                                icon(arrayOf("fa", "sliders-h"))
                            }
                        }
                    }
                }
            }
        }
    }
}


private val stylesSideMenu: VCssRuleSet = {
    display = Display.flex
    alignItems = Align.center
}
