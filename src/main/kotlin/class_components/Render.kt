//package wrapper


//class VBuilder() {
//    var tag: Any? = null
//    var params: types.vue.types.vue.external_declarations.vue.VNodeData<Any> = jsObject { }
//    var children: ArrayList<Any> = arrayListOf()
//
//    fun getChildren(createElement: types.vue.external_declarations.vue.CreateElement): Any {
//        return children.toTypedArray()
//    }
//
//    fun children(builder: ArrayList<Any>.() -> Unit) {
//        children.builder()
//    }
//
//    operator fun String.unaryPlus() {
//        children.add(this)
//    }
//}

//abstract class external_declarations.vue.Component : types.vue.external_declarations.vue.Vue() {
//    @JsName("render")
//    abstract fun render(h: types.vue.external_declarations.vue.CreateElement): types.vue.types.vue.external_declarations.vue.VNode
//}

//class ComponentBuilder<P> {
//    var componentName: String = ""
//    val propData: MutableMap<String, types.vue.external_declarations.vue.PropOptions> = mutableMapOf()
//    var component: external_declarations.vue.Component? = null
//    var props: P.() -> Unit = {}
//
//    fun propData(builder: MutableMap<String, types.vue.external_declarations.vue.PropOptions>.() -> Unit) = propData.builder()
//
//}

//inline fun <P : Any> VBuilder.component(
//    h: types.vue.external_declarations.vue.CreateElement, crossinline build: ComponentBuilder<P>.() -> Unit
//): types.vue.types.vue.external_declarations.vue.VNode {
//
//    val componentBuilder = ComponentBuilder<P>()
//    componentBuilder.build()
//
//    val componentProps = jsObject<types.vue.types.vue.external_declarations.vue.VNodeData<P>> {
//        props = jsObject(componentBuilder.props)
//    }
//
//    val componentPropsData = jsObject<Any> { }
//    componentBuilder.propData.map { componentPropsData.asDynamic()[it.key] = it.value }
//
//    val component = h(
//        vComponent(
//            componentBuilder.component!!::class.js,
//            componentPropsData,
//            componentBuilder.componentName
//        ),
//        componentProps
//    )
//
//    children { add(component) }
//
//    return component
//}


//inline fun VBuilder.div(h: types.vue.external_declarations.vue.CreateElement, builder: VBuilder.() -> Unit): types.vue.types.vue.external_declarations.vue.VNode {
//    val element = VBuilder().apply(builder)
//    element.tag = "div"
//    val child = h(element.tag, element.params, element.getChildren(h))
//    children { add(child) }
//    return child
//}


//interface types.vue.external_declarations.vue.PropOptions {
//    var type: JsClass<*>?
//    var required: Boolean?
//    var default: Any?
//    var validator: (value: Any) -> Boolean
//}
