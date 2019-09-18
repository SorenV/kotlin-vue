import kotlinx.html.id
import views.container
import wrapper.div
import wrapper.vComponent
import wrapper.vRender


fun app() = vComponent<Unit> {
    name = "App"
    setup = { _, ctx ->

        ctx.parent?.`$router`?.let { provideRouter(it) }

        vRender {
            div {
                `class` = "full-app-wrapper"
                attrs {
                    id = "app"
                }
                container().h()
            }
        }
    }
}



