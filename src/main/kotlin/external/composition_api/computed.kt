@file:JsModule("@vue/composition-api")

package external.composition_api

external fun <T> computed(getter: () -> T): Ref<T>

external interface Options<T> {
    var get: () -> T
    var set: (value: T) -> Unit
}

external fun <T> computed(options: Options<T>): Ref<T>
