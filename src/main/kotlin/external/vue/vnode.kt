@file:Suppress("unused", "PropertyName")

package external.vue


import org.w3c.dom.Node
import wrapper.OnEvents
import kotlin.js.Json


external interface ScopedSlotReturnArray
external interface VNodeChildrenArrayContents


external interface VNode {
    var tag: String? get() = definedExternally; set(value) = definedExternally
    var data: VNodeData<*, *, *>? get() = definedExternally; set(value) = definedExternally
    var children: Array<VNode>? get() = definedExternally; set(value) = definedExternally
    var text: String? get() = definedExternally; set(value) = definedExternally
    var elm: Node? get() = definedExternally; set(value) = definedExternally
    var ns: String? get() = definedExternally; set(value) = definedExternally
    var context: Vue? get() = definedExternally; set(value) = definedExternally
    var key: dynamic /* String | Number */
    var componentOptions: VNodeComponentOptions? get() = definedExternally; set(value) = definedExternally
    var componentInstance: Vue? get() = definedExternally; set(value) = definedExternally
    var parent: VNode? get() = definedExternally; set(value) = definedExternally
    var raw: Boolean? get() = definedExternally; set(value) = definedExternally
    var isStatic: Boolean? get() = definedExternally; set(value) = definedExternally
    var isRootInsert: Boolean
    var isComment: Boolean
}

external interface VNodeComponentOptions {
    var Ctor: Any
    var propsData: Any? get() = definedExternally; set(value) = definedExternally
    var listeners: Any? get() = definedExternally; set(value) = definedExternally
    var children: Array<VNode>? get() = definedExternally; set(value) = definedExternally
    var tag: String? get() = definedExternally; set(value) = definedExternally
}


external interface VNodeData<P, A, D> {

    /**
     * ts type - string | number
     */
    var key: dynamic get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - string
     */
    var slot: String? get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - { [key: string]: ScopedSlot | undefined }
     * example type - { name: (props) => VNode | Array<VNode> }
     */
    var scopedSlots: ScopedSlots? get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - string
     */
    var ref: String? get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - boolean
     */
    var refInFor: Boolean? get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - any
     */
    var `class`: Any? get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - string | object[] | object
     */
    var style: dynamic /* String | Array<Any?> | Any? */ get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - { [key: string]: any }
     */
    var props: P? get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - { [key: string]: any }
     */
    var attrs: A? get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - { [key: string]: any }
     */
    var domProps: D? get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - { [key: string]: Function | Function[] }
     */
    var on: OnEvents? get() = definedExternally; set(value) = definedExternally

    /**
     * ts type - { [key: string]: Function | Function[] }
     */
    var nativeOn: Json? get() = definedExternally; set(value) = definedExternally

    /**
     *  ts type - VNodeDirective {
     *                  name: string;
     *                  value?: any;
     *                  oldValue?: any;
     *                  expression?: any;
     *                  arg?: string;
     *                  oldArg?: string;
     *                  modifiers?: { [key: string]: boolean };
     *             }
     */
    var directives: Array<VNodeDirective>? get() = definedExternally; set(value) = definedExternally

    var keepAlive: Boolean? get() = definedExternally; set(value) = definedExternally
    var tag: String? get() = definedExternally; set(value) = definedExternally
    var staticClass: String? get() = definedExternally; set(value) = definedExternally
    var staticStyle: Json? get() = definedExternally; set(value) = definedExternally
    var hook: Json? get() = definedExternally; set(value) = definedExternally
    var transition: Any? get() = definedExternally; set(value) = definedExternally
    var show: Boolean? get() = definedExternally; set(value) = definedExternally
    var inlineTemplate: InlineTemplate? get() = definedExternally; set(value) = definedExternally
}

external interface InlineTemplate {
    var render: Function<*>
    var staticRenderFns: Array<Function<*>>
}


external interface VNodeDirective {
    var name: String? get() = definedExternally; set(value) = definedExternally
    var value: Any? get() = definedExternally; set(value) = definedExternally
    var oldValue: Any? get() = definedExternally; set(value) = definedExternally
    var expression: Any? get() = definedExternally; set(value) = definedExternally
    var arg: String? get() = definedExternally; set(value) = definedExternally
    var oldArg: String? get() = definedExternally; set(value) = definedExternally
    var modifiers: Modifiers? get() = definedExternally; set(value) = definedExternally
}

external interface Modifiers

inline operator fun Modifiers.get(key: String): Boolean? = asDynamic()[key].unsafeCast<Boolean?>()

inline operator fun Modifiers.set(key: String, value: Boolean) {
    asDynamic()[key] = value
}



typealias ScopedSlot <P> = (props: P) -> VNode
typealias NormalizedScopedSlot = (props: Any) -> Array<VNode>?


class VScopedSlots : ScopedSlots
external interface ScopedSlots

inline operator fun <P> ScopedSlots.get(key: String): ScopedSlot<P>? = asDynamic()[key].unsafeCast<ScopedSlot<P>?>()

inline operator fun <P> ScopedSlots.set(key: String, noinline value: ScopedSlot<P>) {
    asDynamic()[key] = value
}

inline operator fun ScopedSlots.set(key: String, noinline value: NormalizedScopedSlot) {
    asDynamic()[key] = value
}

