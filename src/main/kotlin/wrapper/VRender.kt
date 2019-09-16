package wrapper

import external.composition_api.SetupContext
import external.composition_api.Slot
import external.composition_api.createElement
import external.composition_api.invoke
import external.vue.ScopedSlot
import external.vue.VNode
import external.vue.invoke
import kotlinext.js.jsObject


@JsName("render")
fun vRender(render: VRender<*, *, *>.() -> Unit): () -> VNode = {

    VRender<Unit, Unit, Unit>().apply(render).getChildren()[0].unsafeCast<VNode>()
}

fun vRenderComponent(render: VRender<*, *, *>.() -> Unit): VNode {

    return VRender<Unit, Unit, Unit>().apply(render).getChildren()[0].unsafeCast<VNode>()
}


open class VRender<P : Any, A, D> : VNodeDataBuilder<P, A, D>() {

    fun <T : Any> VComponent<T>.h(builder: (VRender<T, Any, Any>.() -> Unit)? = null): VNode {
        val vNodeData = VRender<T, Any, Any>()

        builder?.let { vNodeData.apply(it) }

        vNodeData.propsBuilder?.let {
            vNodeData.props = this.propsConstructor?.apply(it) ?: jsObject(it)
            vNodeData.propsBuilder = undefined
        }

        val vNode = createElement(this, vNodeData, vNodeData.getChildren())
        child(vNode)
        return vNode
    }

    fun setSlot(name: String, ctx: SetupContext) =
        ctx.slots?.get(name).unsafeCast<Slot?>()?.invoke()?.let { child(it) }

    fun <Props : Any> setSlot(name: String, ctx: SetupContext, builder: Props.() -> Unit) =
        ctx.slots?.get(name).unsafeCast<ScopedSlot<Props>?>()?.invoke(jsObject(builder))?.let { child(it) }

    fun <Props : Any> setSlot(props: Props, name: String, ctx: SetupContext, builder: Props.() -> Unit) =
        ctx.slots?.get(name).unsafeCast<ScopedSlot<Props>?>()?.invoke(props.apply(builder))?.let { child(it) }


}

inline fun VRender<*, *, *>.h(tag: String, builder: VRender<Unit, Unit, Unit>.() -> Unit): VNode {

    val vNodeData = VRender<Unit, Unit, Unit>().apply(builder)

    val vNode = createElement(tag, vNodeData, vNodeData.getChildren())
    child(vNode)
    return vNode
}

fun <P : Any, A, D> VRender<*, *, *>.h(tag: String, builder: VRender<P, A, D>.() -> Unit, props: P): VNode {
    val vNodeData = VRender<P, A, D>().apply(builder)

    vNodeData.propsBuilder?.let {
        vNodeData.props = props.apply(it)
    }

    val vNode = createElement(tag, vNodeData, vNodeData.getChildren())
    child(vNode)
    return vNode
}

fun <P : Any> VRender<*, *, *>.h(tag: P, builder: VRender<P, Any, Any>.() -> Unit): VNode {

    val vNodeData = VRender<P, Any, Any>().apply(builder)

    vNodeData.propsBuilder?.let {
        vNodeData.props = jsObject(it)
    }

    val vNode = createElement(tag, vNodeData, vNodeData.getChildren())
    child(vNode)
    return vNode
}

fun VRender<*, *, *>.h(tag: String): VNode {
    val vNode = createElement(tag)
    child(vNode)
    return vNode
}


