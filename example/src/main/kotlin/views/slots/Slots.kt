package views.slots

import wrapper.div
import wrapper.vComponent
import wrapper.vRender

fun slots() = vComponent<Unit> {
    name = "Slots"

    css { }

    setup = { _, _ ->
        vRender {
            div {
                +"Slots"
                componentWithSlot().h {
                    div {
                        slot = "name-of-slot"
                        +"I'm in the slot"
                    }
                }
            }
        }
    }
}


fun componentWithSlot() = vComponent<Unit> {
    name = "ComponentWithSlot"

    setup = { _, ctx ->
        vRender {
            div {
                +"Component with slot"
                setSlot("name-of-slot", ctx)
            }
        }
    }
}


