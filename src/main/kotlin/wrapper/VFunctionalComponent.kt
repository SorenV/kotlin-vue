package wrapper

import external.composition_api.Symbol
import external.vue.*
import kotlinext.js.jsObject

typealias VFunctionalComponentBuilder<P> = VFunctionalComponent<P>.() -> Unit
typealias VFunctionalComponentRender<P> = (createElement: CreateElement, context: RenderContext<P>) -> Array<VNode>


abstract class VFunctionalComponent<P : Any>(
    builder: VFunctionalComponentBuilder<P>? = null,
    renderProps: P? = null
) : VNodeDataBuilder<P, Unit, Unit>() {

    var injectOption: Any? = null

    var propDefs: VPropDefs? = null

    var renderFunction: VFunctionalComponentRender<P>? = null

    var modelBuilder: (Model.() -> Unit)? = null

    init {
        builder?.let { apply(it) }

        propsBuilder?.let {
            props = renderProps?.apply(it) ?: jsObject(it)
        }
    }

    fun inject(value: Array<String>) {
        injectOption = value
    }

    fun inject(value: Pair<String, Symbol>) {
        injectOption = value
    }

    fun inject(value: Pair<String, String>) {
        injectOption = value
    }

    fun inject(builder: InjectOption.() -> Unit) {
        injectOption = jsObject(builder)
    }

    fun css(builder: VCssRuleSet) {
        val css = VCssBuilder().apply(builder)
        buildCss(css, this::class.simpleName)
    }

    fun propData(builder: PropData.() -> Unit) {
        propDefs = buildPropDefs(builder)
    }

    fun model(builder: Model.() -> Unit) {
        modelBuilder = builder
    }

    fun render(
        render: VRender.(createElement: CreateElement, context: RenderContext<P>) -> Unit
    ) {
        renderFunction = { h, ctx -> VRenderer<P, Unit, Unit>().apply { render(h, ctx) }.getChildren() }
    }

    fun component(): FunctionalComponentOptions<P> {
        return jsObject {
            name = this@VFunctionalComponent::class.simpleName
            props = propDefs
            model = modelBuilder?.let { jsObject(it) }
            inject = injectOption
            functional = true
            render = renderFunction
        }
    }
}

class VFunctionalComponentFuncBuilder<P : Any>(renderProps: P? = null) :
    VFunctionalComponent<P>(renderProps = renderProps) {
    var name: String? = null
}

fun <P : Any> vFunctionalComponent(
    renderProps: P? = null,
    builder: VFunctionalComponentFuncBuilder<P>.() -> Unit
): VFunctionalComponentFuncBuilder<P> {
    return VFunctionalComponentFuncBuilder(renderProps).apply(builder)
}
