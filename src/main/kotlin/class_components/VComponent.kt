//import external_declarations.composition_api.RenderFunction
//import external_declarations.composition_api.SetupFunction
//import kotlinext.js.jsObject
//import org.w3c.dom.Element
//import org.w3c.dom.css.CSSStyleSheet
//import wrapper.PropData
//import wrapper.types.vue.external_declarations.vue.PropOptions
//import wrapper.VCssBuilder
//import wrapper.VCssRuleSet
//import kotlin.browser.document
//
//abstract class AVComponent<P> {
//    init {
//        buildCss()
//    }
//    abstract var name: String
//    abstract var css: VCssRuleSet
//    abstract var props: PropsDataBuilder
//    abstract var setup: SetupFunction<P>
//
//    private fun buildCss() {
//        val builtCss = VCssBuilder().apply(css)
//
//        val style: Element = document.createElement("style")
//
//        // if the stylesheet has already been built, return
//        document.getElementById(name)?.let { return }
//
//        style.id = name
//        style.setAttribute("type", "text/css")
//        document.head?.appendChild(style)
//        val sheet = style.asDynamic().sheet.unsafeCast<CSSStyleSheet>()
//
//        builtCss.rules.withIndex().map {
//            sheet.insertRule(it.value.toString(), it.index)
//        }
//    }
//
//    private fun buildPropsData(){
//        PropData().apply(props).propDefinitions.map {
//            props.asDynamic()[it.key] = jsObject<types.vue.external_declarations.vue.PropOptions> {
//                type = it.value.type
//                required = it.value.required
//                validator = it.value.validator
//                default = it.value.default
//            }
//        }
//    }
//}
//
//typealias PropsDataBuilder =  PropData.() -> Unit
//
//inline fun <P> AVComponent<P>.props(builder: PropData.() -> Unit) {
//
//}
//
//inline fun <P> AVComponent<P>.css(builder: VCssRuleSet) {
//
//    css.builder()
//
//
//}
