@file:Suppress("unused")

package external.vue

typealias PluginFunction<T> = (IVue: Any, options: T? /* = null */) -> Unit

external interface PluginObject<T> {
    var install: PluginFunction<T>
}

inline operator fun <T> PluginObject<T>.get(key: String): Any? = asDynamic()[key].unsafeCast<Any?>()

inline operator fun <T> PluginObject<T>.set(key: String, value: Any) {
    asDynamic()[key] = value
}
