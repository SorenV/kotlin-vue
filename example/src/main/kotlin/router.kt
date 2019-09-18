import external.composition_api.inject
import external.composition_api.invoke
import external.composition_api.provide
import external.composition_api.symbol
import external.vue.VueRouter
import views.directives.directives
import views.forms.refsExample
import views.home.home
import views.reactive_api.reactiveApi
import views.reactive_api.reactiveExample
import views.slots.scopedSlots
import views.slots.slots
import wrapper.vRouter

val vRouter = vRouter {
    mode = "history"

    vRoute {
        path = "/"
        name = "home"
        component = home()
    }

    vRoute {
        path = "/directives"
        name = "directives"
        component = directives()
    }

    vRoute {
        path = "/reactive_api"
        name = "reactiveApi"
        component = reactiveApi()

        childRoute {
            path = "reactive"
            name = "reactive"
            component = reactiveExample()
        }

        childRoute {
            path = "refs"
            name = "ref"
            component = refsExample()
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

val routerSymbol = symbol("Router")

fun provideRouter(providedRouter: VueRouter) {
    provide(routerSymbol, providedRouter)
}

fun useRouter(): VueRouter {
    val injectedRouter = inject<VueRouter>(routerSymbol)

    if (injectedRouter is VueRouter) {
        return injectedRouter
    } else {
        throw Error("[App] - No router was available for injection")
    }
}
