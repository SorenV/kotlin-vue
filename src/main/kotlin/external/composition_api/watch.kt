@file:JsModule("@vue/composition-api")

package external.composition_api


external interface WatchOptions {
    var lazy: Boolean? get() = definedExternally; set(value) = definedExternally
    var flush: String
    var deep: Boolean? get() = definedExternally; set(value) = definedExternally
}

external fun watch(
    effect: (onInvalidate: InvalidationRegister) -> Unit,
    options: WatchOptions? = definedExternally
): StopHandle

external fun <T> watch(
    source: Ref<T>,
    effect: (value: T, oldValue: T, onInvalidate: InvalidationRegister) -> Unit,
    options: WatchOptions? = definedExternally /* null */
): StopHandle

external fun <T> watch(
    source: () -> T,
    effect: (value: T, oldValue: T, onInvalidate: InvalidationRegister) -> Unit,
    options: WatchOptions? = definedExternally /* null */
): StopHandle

external fun <T : Array<dynamic /* Ref<Any> | () -> Any */>> watch(
    sources: T,
    effect: (values: MapSources<T>, oldValues: MapSources<T>, onInvalidate: InvalidationRegister) -> Unit,
    options: WatchOptions? = definedExternally /* null */
): StopHandle
