@file:Suppress("unused")

package external.vue


import org.w3c.dom.HTMLElement
import kotlin.js.Json
import kotlin.js.Promise

external interface Record<K, T>
external interface Component : IVue
external interface Constructor
external interface EsModuleComponent {
    var default: Component
}
typealias AsyncComponentPromise<Props> = (resolve: (component: dynamic /* Any | FunctionalComponentOptions<Props> | ComponentOptions<Any, Data, Methods, Computed, Props> */) -> Unit, reject: (reason: Any? /* = null */) -> Unit) -> dynamic

external interface AsyncComponent<Props> {
    var component: AsyncComponentPromise<Props>
    var loading: dynamic /* Component | EsModuleComponent */
    var error: dynamic /* Component | EsModuleComponent */
    var delay: Number? get() = definedExternally; set(value) = definedExternally
    var timeout: Number? get() = definedExternally; set(value) = definedExternally
}
typealias AsyncComponentFactory<Props> = () -> AsyncComponent<Props>
typealias Accessors = Any
typealias DefaultProps = Record<String, Any>

external interface DefaultMethods<V>


inline operator fun <V> DefaultMethods<V>.get(key: String): ((`this`: V, args: Any) -> Any)? =
    asDynamic()[key].unsafeCast<((`this`: V, args: Any) -> Any)?>()


inline operator fun <V> DefaultMethods<V>.set(key: String, noinline value: (`this`: V, args: Array<Any>) -> Any) {
    asDynamic()[key] = value
}

external interface DefaultComputed


inline operator fun DefaultComputed.get(key: String): Any? = asDynamic()[key].unsafeCast<Any?>()


inline operator fun DefaultComputed.set(key: String, value: Any) {
    asDynamic()[key] = value
}

external interface Directives

inline operator fun Directives.get(key: String): dynamic /* DirectiveFunction | DirectiveOptions */ =
    asDynamic()[key]


inline operator fun Directives.set(key: String, noinline value: DirectiveFunction) {
    asDynamic()[key] = value
}


inline operator fun Directives.set(key: String, value: DirectiveOptions) {
    asDynamic()[key] = value
}

external interface Components


inline operator fun Components.get(key: String): dynamic /* Any | FunctionalComponentOptions<Any> | ComponentOptions<Any, Any, Any, Any, Any> | AsyncComponentPromise<Any, Any, Any, Any> | AsyncComponentFactory<Any, Any, Any, Any> */ =
    asDynamic()[key]


inline operator fun Components.set(key: String, value: Any) {
    asDynamic()[key] = value
}


inline operator fun Components.set(key: String, value: FunctionalComponentOptions<Any>) {
    asDynamic()[key] = value
}


inline operator fun Components.set(key: String, value: ComponentOptions<Any>) {
    asDynamic()[key] = value
}


inline operator fun Components.set(key: String, noinline value: AsyncComponentPromise<Any>) {
    asDynamic()[key] = value
}


inline operator fun Components.set(key: String, noinline value: AsyncComponentFactory<Any>) {
    asDynamic()[key] = value
}

external interface Transitions


inline operator fun Transitions.get(key: String): Any? = asDynamic()[key].unsafeCast<Any?>()


inline operator fun Transitions.set(key: String, value: Any?) {
    asDynamic()[key] = value
}

external interface Filters


inline operator fun Filters.get(key: String): Function<*>? = asDynamic()[key].unsafeCast<Function<*>?>()


inline operator fun Filters.set(key: String, value: Function<*>) {
    asDynamic()[key] = value
}

external interface InjectOption {
    var from: dynamic /* String | Any */
    var default: Any? get() = definedExternally; set(value) = definedExternally
}

external interface Inject


inline operator fun Inject.get(key: String): dynamic /* String | Any | InjectOption */ = asDynamic()[key]


inline operator fun Inject.set(key: String, value: String) {
    asDynamic()[key] = value
}


inline operator fun Inject.set(key: String, value: Any) {
    asDynamic()[key] = value
}


inline operator fun Inject.set(key: String, value: InjectOption) {
    asDynamic()[key] = value
}

external interface Model {
    var prop: String? get() = definedExternally; set(value) = definedExternally
    var event: String? get() = definedExternally; set(value) = definedExternally
}

external interface ComponentOptions<Props> {
    var data: Any? get() = definedExternally; set(value) = definedExternally
    var props: PropDefs? get() = definedExternally; set(value) = definedExternally
    var propsData: Any? get() = definedExternally; set(value) = definedExternally
    var computed: Accessors? get() = definedExternally; set(value) = definedExternally
    var methods: Any? get() = definedExternally; set(value) = definedExternally
    var watch: Record<String, dynamic /* WatchOptionsWithHandler<Any> | WatchHandler<Any> | String */>? get() = definedExternally; set(value) = definedExternally
    var el: dynamic /* Element | String */
    var template: String? get() = definedExternally; set(value) = definedExternally
    var render: (createElement: CreateElement?) -> VNode
    val renderError: ((createElement: CreateElement, err: Error) -> VNode)? get() = definedExternally
    var staticRenderFns: Array<(createElement: CreateElement) -> VNode>? get() = definedExternally; set(value) = definedExternally
    val beforeCreate: ((`this`: IVue) -> Unit)? get() = definedExternally
    val created: (() -> Unit)? get() = definedExternally
    val beforeDestroy: (() -> Unit)? get() = definedExternally
    val destroyed: (() -> Unit)? get() = definedExternally
    val beforeMount: (() -> Unit)? get() = definedExternally
    val mounted: (() -> Unit)? get() = definedExternally
    val beforeUpdate: (() -> Unit)? get() = definedExternally
    val updated: (() -> Unit)? get() = definedExternally
    val activated: (() -> Unit)? get() = definedExternally
    val deactivated: (() -> Unit)? get() = definedExternally
    val errorCaptured: ((err: Error, vm: IVue, info: String) -> dynamic)? get() = definedExternally
    val serverPrefetch: ((`this`: IVue) -> Promise<Unit>)? get() = definedExternally
    var directives: Directives? get() = definedExternally; set(value) = definedExternally
    var components: Components? get() = definedExternally; set(value) = definedExternally
    var transitions: Transitions? get() = definedExternally; set(value) = definedExternally
    var filters: Filters? get() = definedExternally; set(value) = definedExternally
    var provide: dynamic /* Any? | () -> Any? */
    var inject: dynamic /* Inject | Array<String> */
    var model: Model? get() = definedExternally; set(value) = definedExternally
    var parent: IVue? get() = definedExternally; set(value) = definedExternally
    var mixins: Array<dynamic /* ComponentOptions<IVue> | Any */>? get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var extends: dynamic /* ComponentOptions<IVue> | Any */
    var delimiters: dynamic /* JsTuple<String, String> */
    var comments: Boolean? get() = definedExternally; set(value) = definedExternally
    var inheritAttrs: Boolean? get() = definedExternally; set(value) = definedExternally
    var router: VueRouter? get() = definedExternally; set(value) = definedExternally
}

external interface FunctionalComponentOptions<Props> {
    var name: String? get() = definedExternally; set(value) = definedExternally
    var props: PropDefs? get() = definedExternally; set(value) = definedExternally
    var model: Model? get() = definedExternally; set(value) = definedExternally
    var inject: dynamic /* Inject | Array<String> */
    var functional: Boolean
    val render: ((`this`: Nothing?, createElement: CreateElement, context: RenderContext<Props>) -> dynamic)? get() = definedExternally
}

interface PropDefs {
    var name: String?
    var type: JsClass<*>?
    var required: Boolean?
    var default: Any?
    var validator: ((value: Any) -> Boolean)?
}

external interface Listeners


inline operator fun Listeners.get(key: String): dynamic /* Function<*> | Array<Function<*>> */ = asDynamic()[key]


inline operator fun Listeners.set(key: String, value: Function<*>) {
    asDynamic()[key] = value
}


inline operator fun Listeners.set(key: String, value: Array<Function<*>>) {
    asDynamic()[key] = value
}


external interface RenderContext<Props> {
    var props: Props
    var children: Array<VNode>
    fun slots(): Any
    var data: VNodeData<*, *, *>
    var parent: IVue
    var listeners: Listeners
    var scopedSlots: Json?
    var injections: Any
}

external interface PropOptions<T> {
    var type: dynamic
    var required: Boolean? get() = definedExternally; set(value) = definedExternally
    var default: dynamic /* T | Nothing? | Nothing? | () -> T? */
    val validator: ((value: T) -> Boolean)? get() = definedExternally
}

typealias RecordPropsDefinition = Any

typealias ArrayPropsDefinition = Array<Any>

external interface ComputedOptions<T> {
    val get: (() -> T)? get() = definedExternally
    val set: ((value: T) -> Unit)? get() = definedExternally
    var cache: Boolean? get() = definedExternally; set(value) = definedExternally
}

typealias WatchHandler<T> = (value: T, oldValue: T) -> Unit

external interface WatchOptions {
    var deep: Boolean? get() = definedExternally; set(value) = definedExternally
    var immediate: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface WatchOptionsWithHandler<T> : WatchOptions {
    var handler: WatchHandler<T>
}

external interface DirectiveBinding {
    val name: String
    val value: Any? get() = definedExternally
    val expression: Any? get() = definedExternally
    val arg: String? get() = definedExternally
    val oldArg: String? get() = definedExternally
    var modifiers: Modifiers
}
typealias DirectiveFunction = (el: HTMLElement, binding: DirectiveBinding, vnode: VNode, oldVnode: VNode) -> Unit

external interface DirectiveOptions {
    var bind: DirectiveFunction? get() = definedExternally; set(value) = definedExternally
    var inserted: DirectiveFunction? get() = definedExternally; set(value) = definedExternally
    var update: DirectiveFunction? get() = definedExternally; set(value) = definedExternally
    var componentUpdated: DirectiveFunction? get() = definedExternally; set(value) = definedExternally
    var unbind: DirectiveFunction? get() = definedExternally; set(value) = definedExternally
}

