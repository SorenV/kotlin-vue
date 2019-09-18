import kotlinx.html.id
import views.Container
import wrapper.VComponent
import wrapper.div
import wrapper.vRender


class App : VComponent<Unit>() {
    init {
        setup { _, ctx ->

            ctx.parent?.`$router`?.let { provideRouter(it) }

            vRender {
                div {
                    `class` = "full-app-wrapper"
                    attrs {
                        id = "app"
                    }
                    +Container()
                }
            }
        }
    }
}



