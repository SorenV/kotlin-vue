package wrapper

import external.composition_api.SetupContext
import external.composition_api.SetupFunction
import kotlinext.js.jsObject

typealias VComponentBuilder<P> = VComponent<P>.() -> Unit

abstract class VComponent<P : Any>(
    builder: VComponentBuilder<P>? = null,
    renderProps: P? = null
) : VNodeDataBuilder<P, Unit, Unit>() {

    private var propData: PropData? = null

    private var setupFunction: SetupFunction<*>? = null

    var css = VCssBuilder()

    init {
        builder?.let { apply(it) }

        propsBuilder?.let {
            props = renderProps?.apply(it) ?: jsObject(it)
        }
    }

    fun css(builder: VCssRuleSet) {
        css.builder()
        buildCss(css, this::class.simpleName)
    }

    fun propData(builder: PropData.() -> Unit) {
        propData = buildPropsData(builder)
    }

    fun setup(value: SetupFunction<P>) {
        setupFunction = value
    }

    fun component(): VComponentOptions {
        return jsObject {
            name = this@VComponent::class.simpleName
            props = propData
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
    var props: PropData?
    var setup: SetupFunction<*>?
}



