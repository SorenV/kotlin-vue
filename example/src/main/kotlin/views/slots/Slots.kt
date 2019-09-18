package views.slots

import wrapper.VComponent
import wrapper.VComponentBuilder
import wrapper.div
import wrapper.vRender

class Slots : VComponent<Unit>() {
    init {
        css { }

        setup { _, _ ->
            vRender {
                div {
                    +"Slots"
                    ComponentWithSlot {
                        div {
                            slot = "name-of-slot"
                            +"I'm in the slot"
                        }
                    }
                }
            }
        }
    }
}


class ComponentWithSlot(builder: VComponentBuilder<Unit>) : VComponent<Unit>(builder) {
    init {
        setup { _, ctx ->
            vRender {
                div {
                    +"Component with slot"
                    setSlot("name-of-slot", ctx)
                }
            }
        }
    }
}


