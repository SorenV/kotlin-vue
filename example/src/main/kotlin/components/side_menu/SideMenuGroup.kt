package components.side_menu

import external.composition_api.computed
import external.composition_api.onMounted
import external.composition_api.ref
import external.font_awsome.FaIcon
import kotlinx.css.*
import kotlinx.css.properties.*
import org.w3c.dom.Element
import wrapper.*
import kotlin.js.json


interface SideMenuGroupProps {
    var icon: String
    var title: String
}


class SideMenuGroup(builder: VComponentBuilder<SideMenuGroupProps>) : VComponent<SideMenuGroupProps>(builder) {
    init {
        css { +stylesSideMenuGroup }

        propData {
            "icon" {
                type = String::class.js
                default = "icons"
            }
            "title"{
                type = String::class.js
                required = true
            }
        }

        setup { props, ctx ->

            val menuItems = ref<Element>(null)
            val opened = ref(false)

            val maxHeight = computed(getter = {
                if (opened.value) {
                    "${menuItems.value?.firstChild?.childNodes?.length?.let { it * 3 }}rem"
                } else {
                    "0"
                }
            })

            val sideMenuStyle = computed(getter = {
                json(
                    "max-height" to maxHeight.value
                )
            })

            onMounted() {
                menuItems.value = getRef("menuItems", ctx)
            }

            vRender {
                div {
                    `class` = "side-menu-group"

                    div {
                        `class` = "menu-item"
                        on { click { opened.value = !opened.value } }

                        div {
                            `class` = "icon"

                            h(FaIcon) {
                                props {
                                    icon = props.icon
                                }
                            }
                        }
                        div { +props.title }
                        h(FaIcon) {

                            `class` = arrayOf(
                                "chevron",
                                json("down" to opened.value)
                            )

                            props {
                                icon = "chevron-right"
                            }
                        }
                    }
                    div {
                        ref = "menuItems"
                        `class` = "side-menu-group-items"
                        style = sideMenuStyle.value

                        setSlot("side-menu-items", ctx)
                    }
                }
            }
        }
    }
}

private val stylesSideMenuGroup: VCssRuleSet = {

    ".side-menu-group-items"{
        width = LinearDimension("100%")
        overflow = Overflow.hidden

        transition("max-height", 0.3.s, Timing.easeInOut)
    }

    ".chevron"{
        color = Color.darkSalmon
        margin = "0.5rem 0.5rem 0.5rem auto"

        transition("transform", 0.2.s, Timing.easeInOut)
    }

    ".chevron.down"{
        transform {
            rotate(90.deg)
        }
    }

    ".side-menu-group-items .menu-item"{
        paddingLeft = LinearDimension("1rem")
    }
}
