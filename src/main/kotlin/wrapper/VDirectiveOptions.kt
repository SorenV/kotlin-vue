package wrapper

import external.vue.DirectiveFunction
import external.vue.DirectiveOptions
import external.vue.VNodeDirective

class VDirective : VNodeDirective

class VDirectiveOptions : DirectiveOptions {

    fun bind(directiveFunction: DirectiveFunction) {
        bind = directiveFunction
    }

    fun inserted(directiveFunction: DirectiveFunction) {
        inserted = directiveFunction
    }

    fun update(directiveFunction: DirectiveFunction) {
        update = directiveFunction
    }

    fun componentUpdated(directiveFunction: DirectiveFunction) {
        componentUpdated = directiveFunction
    }

    fun unbind(directiveFunction: DirectiveFunction) {
        unbind = directiveFunction
    }
}

fun vDirective(builder: VDirectiveOptions.() -> Unit) = VDirectiveOptions().apply(builder)


