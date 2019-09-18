package views

import external.composition_api.Ref
import external.composition_api.ref
import kotlinx.css.*
import wrapper.VComponent
import wrapper.VRender
import wrapper.div
import wrapper.vRender


class Directives : VComponent<Unit>() {
    init {
        css { }

        setup { _, _ ->

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
                    purpleDiv(divBackground, divBorderColor)
                }
            }
        }
    }
}


fun VRender.purpleDiv(divBackground: Ref<Color>, divBorderColor: Ref<Color>) =
    div {
        style {
            marginTop = LinearDimension("1rem")
            height = LinearDimension("10rem")
            width = LinearDimension("10rem")
            backgroundColor = divBackground.value
            borderColor = divBorderColor.value
        }
    }
