package views.directives

import external.composition_api.Ref
import external.composition_api.ref
import kotlinx.css.*
import wrapper.div
import wrapper.vComponent
import wrapper.vRender
import wrapper.vRenderComponent

fun directives() = vComponent<Unit> {

    name = "Directives"

    css { }

    setup = { _, _ ->

        val divBackground = ref(Color.red)
        val divBorderColor = ref(Color.green)

        val externalClick = {
            divBackground.value = Color.blue
        }


        vRender {
            div {
                div {
                    +"Directives"

                    style {
                        height = LinearDimension("10rem")
                        width = LinearDimension("10rem")
                        backgroundColor = divBackground.value
                    }

                    on {
                        click {
                            divBackground.value = Color.red
                        }
                        mouseover {
                            divBackground.value = Color.green
                        }
                    }

                    directives {
                        "on-external-click"{
                            expression = externalClick
                        }
                    }
                }

                child(purpleDiv(divBackground, divBorderColor))
            }
        }
    }
}


fun purpleDiv(
    divBackground: Ref<Color>,
    divBorderColor: Ref<Color>
) = vRenderComponent {
    div {
        style {
            marginTop = LinearDimension("1rem")
            height = LinearDimension("10rem")
            width = LinearDimension("10rem")
            backgroundColor = divBackground.value
            borderColor = divBorderColor.value
        }
    }
}
