@file:JsModule("@vue/composition-api")

package external.composition_api

import external.vue.CreateElement
import wrapper.PropData

@JsName("createElement")
external val createElement: CreateElement


external interface ComponentOptions<Props> {
    var props: PropData?
    var setup: SetupFunction<Props>?
}
