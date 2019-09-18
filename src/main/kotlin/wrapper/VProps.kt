package wrapper

import kotlinext.js.jsObject

fun buildPropsData(builder: PropData.() -> Unit): PropData {
    val propsData = jsObject<PropData> {}
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
