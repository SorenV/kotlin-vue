@file:JsModule("@vue/composition-api")

package external.composition_api

import external.vue.Record
import external.vue.Vue
import kotlin.js.Json

external fun <T> setup(props: T, context: SetupContext): T

external interface SetupContext {
    val attrs: Record<String, String>
    val slots: Json?
    val refs: Json?
    val parent: Vue?
    val root: Vue
    val listeners: Json?
    fun emit(event: String, vararg args: Any)
}
