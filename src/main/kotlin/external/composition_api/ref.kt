@file:JsModule("@vue/composition-api")

package external.composition_api

external interface Ref<T> {
    var value: T
}

external fun <T> ref(): Ref<T?>
external fun <T> ref(raw: Nothing?): Ref<T?>
external fun <T> ref(raw: T): Ref<T>
external fun <T> isRef(value: Any): Boolean
external fun <T> toRefs(obj: T): Refs<T>
