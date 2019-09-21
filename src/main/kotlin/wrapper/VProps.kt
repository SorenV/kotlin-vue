package wrapper

import external.vue.PropDefs
import kotlinext.js.jsObject

fun buildPropDefs(builder: PropData.() -> Unit): VPropDefs {
    val propsData = jsObject<VPropDefs> {}
    PropData().apply(builder).propDefinitions.map {
        propsData.asDynamic()[it.key] = jsObject<PropOptions> {
            type = it.value.type
            required = it.value.required
            validator = it.value.validator
            default = it.value.default
        }
    }
    return propsData
}


class PropData {
    val propDefinitions: MutableMap<String, VPropDefs> = mutableMapOf()

    operator fun String.invoke(builder: VPropDefs.() -> Unit) =
        propDefinitions.set(this, jsObject(builder))
}

class VPropDefs : PropDefs {
    override var name: String? = null
    override var type: Any? = null

    fun type(clazz: JsClass<*>) {
        type = clazz
    }

    fun type(types: Array<JsClass<*>>) {
        type = types
    }

    override var required: Boolean? = null
    override var default: Any? = null
    override var validator: ((value: Any) -> Boolean)? = null
}

interface PropOptions {
    var type: Any?
    var required: Boolean?
    var default: Any?
    var validator: ((value: Any) -> Boolean)?
}
