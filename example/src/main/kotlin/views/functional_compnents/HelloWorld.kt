package views.functional_compnents

import kotlinx.css.Color
import kotlinx.css.color
import wrapper.VFunctionalComponent
import wrapper.VFunctionalComponentBuilder
import wrapper.div
import wrapper.vFunctionalComponent

interface HelloWorldProps {
    var message: String
}

class HelloWorld(builder: VFunctionalComponentBuilder<HelloWorldProps>? = null) :
    VFunctionalComponent<HelloWorldProps>(builder) {
    init {
        propData {
            "message"{
                type = String::class.js
            }
        }
        render { _, _ ->
            div {
                helloWorld().h {
                    props {
                        message = "Hello Worlds!"
                    }
                }
            }
        }
    }
}

fun helloWorld() = vFunctionalComponent<HelloWorldProps> {
    name = "FunctionalComponentFunction"

    css {
        ".message"{
            color = Color.darkOrchid
        }
    }

    propData {
        "message"{
            type = String::class.js
            required = true
        }
    }

    render { _, ctx ->
        div {
            `class` = "message"
            +ctx.props.message
        }
    }
}
