package views.slots


import wrapper.div
import wrapper.vComponent
import wrapper.vRender


interface SlotWithProps {
    var title: String
}

class SlotWithPropsClass {
    var name: String? = null

    fun name(value: String) {
        name = value
    }
}

fun scopedSlots() = vComponent<Unit> {
    name = "ScopedSlots"

    css { }


    setup = { _, _ ->
        vRender {
            div {
                +"Slots"
                componentWithScopedSlot().h {
                    scopedSlots {
                        "slot-with-props"<SlotWithProps> {
                            div {
                                +"In the Div: ${it.title}"

                            }
                        }
                        "slot-with-props-class"<SlotWithPropsClass> {
                            div {
                                +"In the Div: ${it.name}"

                            }
                        }
                        "slot-with-props-array" {
                            arrayOf(
                                div {
                                    +"In the Div:"
                                },
                                div {
                                    +"In second div"
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}


fun componentWithScopedSlot() = vComponent<Unit> {
    name = "ComponentWithScopedSlot"

    setup = { _, ctx ->
        vRender {
            div {
                div {
                    +"Component with slot"
                    setSlot<SlotWithProps>("slot-with-props", ctx) {
                        title = "This is a test Title"
                    }
                }
                div {
                    +"Component with slot class props"
                    setSlot(SlotWithPropsClass(), "slot-with-props-class", ctx) {
                        name("This is a test Name")
                    }
                }
                div {
                    +"Component with slot array"
                    setSlot("slot-with-props-array", ctx)
                }
            }
        }
    }
}
