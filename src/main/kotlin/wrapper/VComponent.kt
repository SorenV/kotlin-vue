package wrapper

import external.composition_api.SetupContext
import external.composition_api.SetupFunction
import kotlinext.js.jsObject
import org.w3c.dom.Element
import org.w3c.dom.css.CSSStyleSheet
import kotlin.browser.document


interface VComponent<P> {
    var propsConstructor: P?
    var name: String?
    var props: Any?
    var setup: SetupFunction<P>?
}

class VComponentBuilder<P> : VComponent<P> {
    override var propsConstructor: P? = null
    override var name: String? = null
    override var props: Any? = null
    override var setup: SetupFunction<P>? = null

    var css = VCssBuilder()

    fun css(builder: VCssRuleSet) {
        css.builder()
    }

    fun buildCss() {

        if (name === null) {
            return
        }

        document.getElementById(name!!)?.let { return }

        val style: Element = document.createElement("style")

        style.id = name!!

        style.setAttribute("type", "text/css")

        document.head?.appendChild(style)

        val sheet = style.asDynamic().sheet.unsafeCast<CSSStyleSheet>()

        css.rules.withIndex().map {
            sheet.insertRule(it.value.toString(), it.index)
        }
    }

    fun <T> getRef(name: String, ctx: SetupContext): T? =
        ctx.refs?.get(name).unsafeCast<T?>()
}

fun <P : Any> vComponent(
    propsConstructor: P? = null,
    builder: VComponentBuilder<P>.() -> Unit
): VComponent<P> {
    val vComponentBuilder = VComponentBuilder<P>().apply(builder)
    vComponentBuilder.buildCss()
    return jsObject {
        this.propsConstructor = propsConstructor
        name = vComponentBuilder.name
        props = vComponentBuilder.props
        setup = vComponentBuilder.setup
    }
}

inline fun <P> VComponent<P>.props(builder: PropData.() -> Unit) {
    props = jsObject { }
    PropData().apply(builder).propDefinitions.map {
        props.asDynamic()[it.key] = jsObject<PropOptions> {
            type = it.value.type
            required = it.value.required
            validator = it.value.validator
            default = it.value.default
        }
    }
}

class PropData {
    val propDefinitions: MutableMap<String, PropDef> = mutableMapOf()

    operator fun String.invoke(builder: PropDef.() -> Unit) =
        propDefinitions.set(this, jsObject(builder))
}

class PropDef {
    var name: String? = null
    var type: Any? = null

    fun type(clazz: JsClass<*>) {
        type = clazz
    }

    fun type(types: Array<JsClass<*>>) {
        type = types
    }

    var required: Boolean? = null
    var default: Any? = null
    var validator: ((value: Any) -> Boolean)? = null
}

interface PropOptions {
    var type: Any?
    var required: Boolean?
    var default: Any?
    var validator: ((value: Any) -> Boolean)?
}




