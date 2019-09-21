package wrapper

import external.vue.VNode


/**
 * https://vuejs.org/v2/api/#keep-alive
 */
class VKeepAlive {
    var include: Any? = null

    fun include(string: String) {
        include = string
    }

    fun include(regex: Regex) {
        include = regex
    }

    fun include(array: Array<String>) {
        include = array
    }

    var exclude: Any? = null

    fun exclude(string: String) {
        exclude = string
    }

    fun exclude(regex: Regex) {
        exclude = regex
    }

    fun exclude(array: Array<String>) {
        exclude = array
    }

    var max: Number? = null
}

fun VRender.keepAlive(render: (VRenderer<VKeepAlive, Any, Any>.() -> Unit)? = null): VNode {
    return render?.let {
        h("keep-alive", render, VKeepAlive())
    } ?: h("keep-alive")
}

