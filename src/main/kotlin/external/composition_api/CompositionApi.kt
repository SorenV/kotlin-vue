@file:JsModule("@vue/composition-api")

package external.composition_api

import external.vue.PluginFunction
import external.vue.PluginObject


@JsName("default")
external object VueCompositionApi : PluginObject<Any> {
    override var install: PluginFunction<Any>
}

