@file:Suppress("unused")

package external.vue

import org.w3c.dom.Element
import kotlin.js.Promise

@JsModule("vue")

open external class Vue(options: ComponentOptions<Any>? = definedExternally) : IVue {

    override var `$el`: Element
    override var `$options`: ComponentOptions<IVue>
    override var `$parent`: IVue
    override var `$root`: IVue
    override var `$children`: Array<IVue>
    override var `$refs`: Refs
    override var `$slots`: Slots
    override var `$scopedSlots`: ScopedSlots
    override var `$isServer`: Boolean
    override var `$data`: Record<String, Any>
    override var `$props`: Record<String, Any>
    override var `$ssrContext`: Any
    override var `$vnode`: VNode
    override var `$attrs`: Record<String, String>
    override var `$listeners`: Record<String, dynamic>

    override fun `$mount`(elementOrSelector: Element?, hydrating: Boolean?): IVue

    override fun `$mount`(elementOrSelector: String?, hydrating: Boolean?): IVue

    override fun `$forceUpdate`()

    override fun `$destroy`()

    override var `$set`: Any
    override var `$delete`: Any

    override fun `$watch`(
        expOrFn: String,
        callback: (IVue, n: Any, o: Any) -> Unit,
        options: WatchOptions?
    ): () -> Unit

    override fun <T> `$watch`(
        expOrFn: (IVue) -> T,
        callback: (IVue, n: T, o: T) -> Unit,
        options: WatchOptions?
    ): () -> Unit

    override fun `$on`(event: String, callback: Function<*>): IVue

    override fun `$on`(event: Array<String>, callback: Function<*>): IVue

    override fun `$once`(event: String, callback: Function<*>): IVue

    override fun `$once`(event: Array<String>, callback: Function<*>): IVue

    override fun `$off`(event: String?, callback: Function<*>?): IVue

    override fun `$off`(event: Array<String>?, callback: Function<*>?): IVue

    override fun `$emit`(event: String, vararg args: Any): IVue

    override fun `$nextTick`(callback: (IVue) -> Unit)

    override fun `$nextTick`(): Promise<Unit>

    override var `$createElement`: CreateElement

    override fun `$mount`(): IVue

    override fun `$off`(): IVue

    companion object : IVueConstructor<Vue> {

        override fun extend(definition: FunctionalComponentOptions<Any>): ExtendedIVue<Vue>

        override fun <Props> extend(definition: FunctionalComponentOptions<Props>): ExtendedIVue<Vue>

        override fun extend(options: ComponentOptions<Vue>?): ExtendedIVue<Vue>

        override fun <T> nextTick(callback: (`this`: T) -> Unit, context: T?)

        override fun nextTick(): Promise<Unit>

        override fun <T> set(`object`: Any?, key: String, value: T): T

        override fun <T> set(`object`: Any?, key: Number, value: T): T

        override fun <T> set(array: Array<T>, key: Number, value: T): T

        override fun delete(`object`: Any?, key: String)

        override fun delete(`object`: Any?, key: Number)

        override fun <T> delete(array: Array<T>, key: Number)

        override fun directive(id: String, definition: DirectiveOptions?): DirectiveOptions

        override fun directive(id: String, definition: DirectiveFunction?): DirectiveOptions

        override fun filter(id: String, definition: Function<*>?): Function<*>

        override fun component(id: String): IVueConstructor<Vue>

        override fun <VC : IVueConstructor<Vue>> component(id: String, constructor: VC): VC

        override fun <Props> component(id: String, definition: AsyncComponent<Props>): ExtendedIVue<Vue>

        override fun component(id: String, definition: FunctionalComponentOptions<Any>): ExtendedIVue<Vue>

        override fun <Props> component(id: String, definition: FunctionalComponentOptions<Props>): ExtendedIVue<Vue>

        override fun component(id: String, definition: ComponentOptions<Vue>?): ExtendedIVue<Vue>

        override fun <T> use(plugin: PluginObject<T>, options: T?): IVueConstructor<Vue>

        override fun <T> use(plugin: PluginFunction<T>, options: T?): IVueConstructor<Vue>

        override fun use(plugin: PluginObject<Any>, vararg options: Any?): IVueConstructor<Vue>

        override fun use(plugin: PluginFunction<Any>, vararg options: Any?): IVueConstructor<Vue>

        override fun mixin(mixin: IVueConstructor<Vue>): IVueConstructor<Vue>

        override fun mixin(mixin: ComponentOptions<IVue>): IVueConstructor<Vue>

        override fun compile(template: String): Compile

        override fun <T> observable(obj: T): T

        override var config: IVueConfiguration

        override var version: String

        override fun extend(): ExtendedIVue<Vue>

        override fun directive(id: String): DirectiveOptions
    }
}

