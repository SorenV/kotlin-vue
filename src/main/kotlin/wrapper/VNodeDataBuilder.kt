@file:Suppress("unused")

package wrapper

import external.vue.*


/**
 * This class contains builders specific to vue elements in general.  i.e. children and vnode data
 */
open class VNodeDataBuilder<P, A, D> : VNodeData<P, A, D> {

    var children: ArrayList<VNode> = arrayListOf()

    fun child(child: VNode) {
        children.add(child)
    }

    operator fun String.unaryPlus() {
        children.add(this.unsafeCast<VNode>())
    }

    fun getChildren(): Array<VNode> {
        return children.toTypedArray()
    }

    var propsBuilder: (P.() -> Unit)? = null

    fun props(builder: P.() -> Unit) {
        propsBuilder = builder
    }

    var attributeBuilder: (A.() -> Unit)? = null

    fun attrs(builder: A.() -> Unit) {
        attributeBuilder = builder
    }

    var domPropsBuilder: (D.() -> Unit)? = null

    fun domProps(builder: D.() -> Unit) {
        domPropsBuilder = builder
    }

    fun style(builder: VCssRuleSet) {
        val vCssBuilder = VCssBuilder().apply(builder)
        style = vCssBuilder.buildDeclarations()
    }

    inline fun directives(builder: VDirectivesBuilder.() -> Unit) {
        VDirectivesBuilder().apply(builder)
    }

    inner class VDirectivesBuilder {

        private val vDirectives = arrayListOf<VNodeDirective>()

        operator fun String.invoke(builder: VDirective.() -> Unit) {

            val directive = VDirective().apply(builder)

            directive.name = this

            vDirectives.add(directive)

            directives = vDirectives.toTypedArray()

        }
    }


    fun scopedSlots(builder: VScopedSlotsBuilder.() -> Unit) {
        VScopedSlotsBuilder().apply(builder)
    }

    inner class VScopedSlotsBuilder {

        operator fun <Props> String.invoke(scopedSlot: ScopedSlot<Props>) {
            scopedSlots ?: run { scopedSlots = VScopedSlots() }
            scopedSlots!![this] = scopedSlot
        }

        operator fun String.invoke(normalizedScopedSlot: NormalizedScopedSlot) {
            scopedSlots ?: run { scopedSlots = VScopedSlots() }
            scopedSlots!![this] = normalizedScopedSlot
        }
    }


    fun on(builder: VOnEvents.() -> Unit) {
        VOnEvents().apply(builder)
    }

    fun nativeOn(builder: VOnEvents.() -> Unit) {
        VOnEvents().apply(builder)
    }

    fun <R> addOnEvent(eventName: String, callback: EventCallback<R>) {
        on ?: run { on = VOnEvents() }
        on!![eventName] = callback
    }

    fun <R> addOnEvents(eventName: String, builder: EventCallbacksBuilder<R>) {
        on ?: run { on = VOnEvents() }
        on!![eventName] = arrayListOf<EventCallback<R>>().apply(builder).toTypedArray()
    }

    inner class VOnEvents : VWebEvents() {

        operator fun <R> String.invoke(callback: EventCallback<R>) = addOnEvent(this, callback)

        fun custom(eventName: String, builder: EventCallbacksBuilder<Any>) = addOnEvents(eventName, builder)
    }

}

