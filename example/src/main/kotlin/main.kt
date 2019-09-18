import directives.initDirectives
import external.composition_api.VueCompositionApi
import external.font_awsome.initFa
import external.vue.Vue
import external.vue.VueRouter
import kotlinext.js.jsObject
import wrapper.vRender
import kotlin.browser.document
import kotlin.browser.window


fun main() {
    initFa()
    initDirectives()

    Vue.use(VueCompositionApi)
    Vue.use(VueRouter)

    Vue.config.productionTip = false

    window.onload = {
        Vue(jsObject {
            router = vRouter
            render = vRender {
                +App()
            }
        }).`$mount`(document.getElementById("root")!!)
    }
}
