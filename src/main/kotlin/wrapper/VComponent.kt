package wrapper

import external.composition_api.SetupContext
import external.composition_api.SetupFunction
import kotlinext.js.jsObject

typealias VComponentBuilder<P> = VComponent<P>.() -> Unit

abstract class VComponent<P : Any>(
    builder: VComponentBuilder<P>? = null,
    renderProps: P? = null
) : VNodeDataBuilder<P, Unit, Unit>() {

    var propDefs: VPropDefs? = null

    var setupFunction: SetupFunction<*>? = null

    init {
        builder?.let { apply(it) }

        propsBuilder?.let {
            props = renderProps?.apply(it) ?: jsObject(it)
        }
    }

    fun css(builder: VCssRuleSet) {
        val css = VCssBuilder().apply(builder)
        buildCss(css, this::class.simpleName)
    }

    fun propData(builder: PropData.() -> Unit) {
        propDefs = buildPropDefs(builder)
    }

    fun setup(value: SetupFunction<P>) {
        setupFunction = value
    }

    fun component(): VComponentOptions {
        return jsObject {
            name = this@VComponent::class.simpleName
            props = propDefs
            setup = setupFunction
        }
    }

    fun slot(VRender: VRender.() -> Unit) {
        child(VRenderer<Unit, Unit, Unit>().apply(VRender).getChildren()[0])
    }

    fun <T> getRef(name: String, ctx: SetupContext): T? =
        ctx.refs?.get(name).unsafeCast<T?>()
}

interface VComponentOptions {
    var name: String?
    var props: VPropDefs?
    var setup: SetupFunction<*>?
}

class VComponentFuncBuilder<P : Any>(renderProps: P? = null) : VComponent<P>(renderProps = renderProps) {
    var name: String? = null
}

fun <P : Any> vComponent(
    renderProps: P? = null,
    builder: VComponentFuncBuilder<P>.() -> Unit
): VComponentFuncBuilder<P> {
    return VComponentFuncBuilder(renderProps).apply(builder)
}
