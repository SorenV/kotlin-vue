package views.users

import wrapper.div
import wrapper.routerView
import wrapper.vComponent
import wrapper.vRender

fun users() = vComponent<Unit> {
    name = "users"

    setup = { _, _ ->
        vRender {
            div {
                +"USERS"
                routerView()
            }
        }
    }
}
