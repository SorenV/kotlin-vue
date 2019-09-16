import kotlinx.html.id
import views.primaryView
import wrapper.div
import wrapper.vComponent
import wrapper.vRender


fun app() = vComponent<Unit> {
    name = "App"
    setup = { _, _ ->


        vRender {
            div {
                `class` = "full-app-wrapper"
                attrs {
                    id = "app"
                }
                primaryView().h()

            }
        }
    }
}



