package views.users

import wrapper.div
import wrapper.vComponent
import wrapper.vRender


fun addUser() = vComponent<Unit> {
    name = "AddUser"

    setup = { _, _ ->
        vRender {
            div {
                +"ADD USER"
            }
        }
    }
}
