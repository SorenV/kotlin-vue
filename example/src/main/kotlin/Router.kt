import views.directives.directives
import views.forms.forms
import views.home.home
import views.slots.scopedSlots
import views.slots.slots
import views.users.addUser
import views.users.editUser
import views.users.users
import wrapper.vRouter

val vRouter = vRouter {
    mode = "history"
    vRoute {
        path = "/"
        name = "home"
        component = home()
    }
    vRoute {
        path = "/forms"
        name = "forms"
        component = forms()
    }

    vRoute {
        path = "/directives"
        name = "directives"
        component = directives()
    }

    vRoute {
        path = "/users"
        name = "users"
        component = users()

        childRoute {
            path = "add"
            name = "addUser"
            component = addUser()
        }

        childRoute {
            path = "edit"
            name = "editUser"
            component = editUser()
        }
    }

    vRoute {
        path = "/slots"
        name = "slots"
        component = slots()
    }

    vRoute {
        path = "/scoped_slots"
        name = "scopedSlots"
        component = scopedSlots()
    }
}
