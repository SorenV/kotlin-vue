@file:Suppress("PropertyName", "unused", "FunctionName")

package external.vue

import org.w3c.dom.Element
import kotlin.js.Promise

external interface CreateElement


inline operator fun <P, A, D> CreateElement.invoke(tag: Any?, data: VNodeData<P, A, D>?, children: Any?): VNode {
    return asDynamic()(tag, data, children).unsafeCast<VNode>()
}

inline operator fun <P, A, D> CreateElement.invoke(tag: String, data: VNodeData<P, A, D>?): VNode {
    return asDynamic()(tag, data).unsafeCast<VNode>()
}

inline operator fun CreateElement.invoke(tag: String): VNode {
    return asDynamic()(tag).unsafeCast<VNode>()
}

inline operator fun CreateElement.invoke(): VNode {
    return asDynamic()().unsafeCast<VNode>()
}


external interface Refs


inline operator fun Refs.get(key: String): dynamic /* types.IVue.external_declarations.IVue.IVue | Element | Array<types.IVue.external_declarations.IVue.IVue> | Array<Element> */ =
    asDynamic()[key]


inline operator fun Refs.set(key: String, value: IVue) {
    asDynamic()[key] = value
}


inline operator fun Refs.set(key: String, value: Element) {
    asDynamic()[key] = value
}


inline operator fun Refs.set(key: String, value: Array<IVue>) {
    asDynamic()[key] = value
}


inline operator fun Refs.set(key: String, value: Array<Element>) {
    asDynamic()[key] = value
}

external interface Slots

inline operator fun Slots.get(key: String): Array<VNode>? = asDynamic()[key].unsafeCast<Array<VNode>?>()


inline operator fun Slots.set(key: String, value: Array<VNode>?) {
    asDynamic()[key] = value
}


external interface IVue {
    var `$el`: Element
    var `$options`: ComponentOptions<IVue>
    var `$parent`: IVue
    var `$root`: IVue
    var `$children`: Array<IVue>
    var `$refs`: Refs
    var `$slots`: Slots
    var `$scopedSlots`: ScopedSlots
    var `$isServer`: Boolean
    var `$data`: Record<String, Any>
    var `$props`: Record<String, Any>
    var `$ssrContext`: Any
    var `$vnode`: VNode
    var `$attrs`: Record<String, String>
    var `$listeners`: Record<String, dynamic /* Function<*> | Array<Function<*>> */>
    fun `$mount`(elementOrSelector: Element? = definedExternally, hydrating: Boolean? = definedExternally): IVue
    fun `$mount`(elementOrSelector: String? = definedExternally, hydrating: Boolean? = definedExternally): IVue
    fun `$forceUpdate`()
    fun `$destroy`()
    var `$set`: Any
    var `$delete`: Any
    fun `$watch`(
        expOrFn: String,
        callback: (`this`: IVue, n: Any, o: Any) -> Unit,
        options: WatchOptions? = definedExternally
    ): () -> Unit

    fun <T> `$watch`(
        expOrFn: (`this`: IVue) -> T,
        callback: (`this`: IVue, n: T, o: T) -> Unit,
        options: WatchOptions? = definedExternally
    ): () -> Unit

    fun `$on`(event: String, callback: Function<*>): IVue
    fun `$on`(event: Array<String>, callback: Function<*>): IVue
    fun `$once`(event: String, callback: Function<*>): IVue
    fun `$once`(event: Array<String>, callback: Function<*>): IVue
    fun `$off`(event: String? = definedExternally, callback: Function<*>? = definedExternally): IVue
    fun `$off`(event: Array<String>? = definedExternally, callback: Function<*>? = definedExternally): IVue
    fun `$emit`(event: String, vararg args: Any): IVue
    fun `$nextTick`(callback: (`this`: IVue) -> Unit)
    fun `$nextTick`(): Promise<Unit>
    var `$createElement`: CreateElement
    fun `$mount`(): IVue
    fun `$off`(): IVue
}
typealias ExtendedIVue<Props> = IVueConstructor<Props>

external interface KeyCodes

inline operator fun KeyCodes.get(key: String): dynamic /* Number | Array<Number> */ = asDynamic()[key]

inline operator fun KeyCodes.set(key: String, value: Number) {
    asDynamic()[key] = value
}

inline operator fun KeyCodes.set(key: String, value: Array<Number>) {
    asDynamic()[key] = value
}

external interface IVueConfiguration {
    var silent: Boolean
    var optionMergeStrategies: Any
    var devtools: Boolean
    var productionTip: Boolean
    var performance: Boolean
    fun errorHandler(err: Error, vm: IVue, info: String)
    fun warnHandler(msg: String, vm: IVue, trace: String)
    var ignoredElements: Array<dynamic /* String | RegExp */>
    var keyCodes: KeyCodes
    var async: Boolean
}

external interface Compile {
    fun render(createElement: Any): VNode
    var staticRenderFns: Array<() -> VNode>
}

external interface IVueConstructor<V : IVue> {

    fun extend(definition: FunctionalComponentOptions<Any>): ExtendedIVue<V>
    fun <Props> extend(definition: FunctionalComponentOptions<Props>): ExtendedIVue<V>
    fun extend(options: ComponentOptions<V>? = definedExternally): ExtendedIVue<V>
    fun <T> nextTick(callback: (`this`: T) -> Unit, context: T? = definedExternally)
    fun nextTick(): Promise<Unit>
    fun <T> set(`object`: Any?, key: String, value: T): T
    fun <T> set(`object`: Any?, key: Number, value: T): T
    fun <T> set(array: Array<T>, key: Number, value: T): T
    fun delete(`object`: Any?, key: String)
    fun delete(`object`: Any?, key: Number)
    fun <T> delete(array: Array<T>, key: Number)
    fun directive(id: String, definition: DirectiveOptions? = definedExternally): DirectiveOptions
    fun directive(id: String, definition: DirectiveFunction? = definedExternally): DirectiveOptions
    fun filter(id: String, definition: Function<*>? = definedExternally): Function<*>
    fun component(id: String): IVueConstructor<V>
    fun <VC : IVueConstructor<V>> component(id: String, constructor: VC): VC
    fun <Props> component(
        id: String,
        definition: AsyncComponent<Props>
    ): ExtendedIVue<V>

    fun component(
        id: String,
        definition: FunctionalComponentOptions<Any>
    ): ExtendedIVue<V>

    fun <Props> component(
        id: String,
        definition: FunctionalComponentOptions<Props>
    ): ExtendedIVue<V>

    fun component(id: String, definition: ComponentOptions<V>? = definedExternally): ExtendedIVue<V>
    fun <T> use(plugin: PluginObject<T>, options: T? = definedExternally): IVueConstructor<V>
    fun <T> use(plugin: PluginFunction<T>, options: T? = definedExternally): IVueConstructor<V>
    fun use(plugin: PluginObject<Any>, vararg options: Any?): IVueConstructor<V>
    fun use(plugin: PluginFunction<Any>, vararg options: Any?): IVueConstructor<V>
    fun mixin(mixin: IVueConstructor<V>): IVueConstructor<V>
    fun mixin(mixin: ComponentOptions<IVue>): IVueConstructor<V>
    fun compile(template: String): Compile
    fun <T> observable(obj: T): T
    var config: IVueConfiguration
    var version: String
    fun extend(): ExtendedIVue<V>
    fun directive(id: String): DirectiveOptions
}
