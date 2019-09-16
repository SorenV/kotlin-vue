package views.users

import wrapper.div
import wrapper.vComponent
import wrapper.vRender

fun editUser() = vComponent<Unit> {
    name = "EditUser"

    setup = { _, _ ->
        vRender {
            div {
                +"EDIT USER"
            }
        }
    }
}
