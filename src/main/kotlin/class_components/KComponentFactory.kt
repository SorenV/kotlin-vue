/**
 * Original idea was to do class components and port the class component api.  This is retained for reference. Along with Render.kt.
 */


//@file:Suppress("unused")
//
//package wrapper
//
//import external_declarations.types.vue.external_declarations.vue.ComponentOptions
//import external_declarations.vue.types.vue.external_declarations.vue.ExtendedVue
//import external_declarations.vue.types.vue.external_declarations.vue.VueConstructor
//import kotlinext.js.Object
//import kotlinext.js.PropertyDescriptor
//import kotlinext.js.jsObject
//
//
//fun multiply(first: Int, second: Int): Int {
//    return first * second
//}
//
//fun vComponent(jsClass: JsClass<out external_declarations.vue.Component>, vProps: Any, componentName: String): types.vue.external_declarations.vue.ExtendedVue<types.vue.external_declarations.vue.Vue> {
//    val options = jsObject<types.vue.external_declarations.vue.ComponentOptions> {
//        props = vProps
//        name = componentName
//    }
//    return kComponentFactory(jsClass, options)
//}
//
//fun kComponentFactory(vComponent: JsClass<out external_declarations.vue.Component>, options: types.vue.external_declarations.vue.ComponentOptions): types.vue.external_declarations.vue.ExtendedVue<types.vue.external_declarations.vue.Vue> {
//
//    val componentOptions = createComponentOptions(vComponent, options)
//
//    val superPrototype = Object.getPrototypeOf(vComponent.asDynamic().prototype).unsafeCast<Any>()
//
//    /**
//     * The check against the superProto as a vue instance is so the context of extends() is correct.
//     */
//    val vueConstructor: types.vue.external_declarations.vue.VueConstructor = if (superPrototype is types.vue.external_declarations.vue.Vue) {
//
//        /**
//         * Set the prototype of the constructor for access to types.vue.external_declarations.vue.Vue static members.
//         *
//         * https://youtrack.jetbrains.com/issue/KT-32161
//         */
//        if (superPrototype.asDynamic().constructor.unsafeCast<types.vue.external_declarations.vue.VueConstructor>().version == null) {
//            Object.asDynamic().setPrototypeOf(superPrototype.asDynamic().constructor, types.vue.external_declarations.vue.Vue::class.js)
//        }
//
//        superPrototype.asDynamic().constructor.unsafeCast<types.vue.external_declarations.vue.VueConstructor>()
//
//    } else {
//
//        types.vue.external_declarations.vue.Vue
//    }
//
//    /**
//     * http://optimizely.github.io/vuejs.org/guide/composition.html
//     */
//    val extendedComponent = vueConstructor.extend<types.vue.external_declarations.vue.Vue>(componentOptions)
//
//    forwardStaticMembers(extendedComponent, vComponent, componentOptions)
//
//    return extendedComponent
//}
//
//
//fun createComponentOptions(
//    VComponent: JsClass<out external_declarations.vue.Component>,
//    options: types.vue.external_declarations.vue.ComponentOptions
//): types.vue.external_declarations.vue.ComponentOptions {
//    val internalHooks = arrayOf(
//        "data",
//        "beforeCreate",
//        "created",
//        "beforeMount",
//        "mounted",
//        "beforeDestroy",
//        "destroyed",
//        "beforeUpdate",
//        "updated",
//        "activated",
//        "deactivated",
//        "render",
//        "errorCaptured", // 2.5
//        "serverPrefetch" // 2.6
//    )
//
//    /**
//     *  Get array of instance properties that are considered types.vue.external_declarations.vue.Vue "Props" in order to not add them as part of the
//     *  options object
//     */
//    val componentProps = options.props?.let {
//        val props = Object.getOwnPropertyNames(it)
//        if (props.any { prop -> prop.matches("_") }) {
//            throw Error("external_declarations.vue.Component props cannot contain underscores '_' ")
//        }
//        props
//    }
//
//    val componentPrototype = VComponent.asDynamic().prototype.unsafeCast<Any>()
//
//    Object.getOwnPropertyNames(componentPrototype).forEach keys@{ key ->
//        if (key === "constructor" || componentProps!!.contains(key)) {
//            return@keys
//        }
//
//        if (internalHooks.contains(key)) {
//            options.asDynamic()[key] = componentPrototype.asDynamic()[key]
//            return@keys
//        }
//
//        val descriptor = Object.getOwnPropertyDescriptor<Any?>(componentPrototype, key)
//
//        @Suppress("SENSELESS_COMPARISON") // TODO remove when Object interface is updated.
//        if (descriptor.value != null) {
//            if (jsTypeOf(descriptor.value) === "function") {
//                if (options.methods == null) {
//                    options.methods = jsObject { }
//                }
//                options.methods.asDynamic()[key] = descriptor.value
//            }
//
//        } else if (descriptor.types.vue.external_declarations.vue.external_declarations.vue.external_declarations.vue.external_declarations.vue.get != null || descriptor.set != null) {
//            if (options.computed == null) {
//                options.computed = jsObject { }
//            }
//            options.computed.asDynamic()[key] = jsObject { }
//            options.computed.asDynamic()[key]["external_declarations.composition_api.types.vue.external_declarations.vue.external_declarations.vue.external_declarations.vue.external_declarations.vue.get"] = descriptor.types.vue.external_declarations.vue.external_declarations.vue.external_declarations.vue.external_declarations.vue.get
//            options.computed.asDynamic()[key]["set"] = descriptor.set
//        }
//    }
//    if (options.mixins.isNullOrEmpty()) {
//        options.mixins = arrayOf()
//    }
//
//    // add data hook to collect class properties as types.vue.external_declarations.vue.Vue instance's data
//    options.mixins.asDynamic()[0] = object {
//
//        @JsName("data")
//        val data = { vm: types.vue.external_declarations.vue.Vue ->
//            collectDataFromConstructor(vm, VComponent, componentProps)
//        }
//    }
//    return options
//}
//
//fun collectDataFromConstructor(vm: types.vue.external_declarations.vue.Vue, vComponent: JsClass<out external_declarations.vue.Component>, componentProps: Array<String>?): Any {
//
//    val originalInit = vComponent.asDynamic().prototype._init
//
//    vComponent.asDynamic().prototype._init = fun() {
//        val self = js("this")
//
//        val vmKeys = Object.getOwnPropertyNames(vm)
//
//        vm.`$options`.props?.let { Object.keys(it) }!!
//            .forEach { key ->
//                if (!vm.asDynamic().hasOwnProperty(key).unsafeCast<Boolean>()) {
//                    vmKeys[vmKeys.size] = key
//                }
//            }
//
//        vmKeys.forEach { key ->
//            if (key[0] != '_') {
//                Object.defineProperty(self, key, jsObject<PropertyDescriptor<dynamic>> {
//                    types.vue.external_declarations.vue.external_declarations.vue.external_declarations.vue.external_declarations.vue.get = { vm.asDynamic()[key] }
//                    set = { value -> vm.asDynamic()[key] = value }
//                    configurable = true
//                })
//            }
//        }
//    }
//
//    // should be acquired class property values
//    val data = js("new vComponent()")
//
//    // restore original _init to avoid memory leak (#209)
//    vComponent.asDynamic().prototype._init = originalInit
//
//    val plainData = jsObject<Any> { }
//
//    Object.keys(data.unsafeCast<Any>())
//        // filter out componentProps that were instantiated as object properties with kotlin mutated names
//        .filterNot { key -> componentProps!!.any { key.matches("^${it}_.+") } }
//        .forEach {
//            if (it.matches("_")) {
//                val missingPropName = "^\\w+(?=_)".toRegex().find(it)?.value ?: it
//                throw Error("$missingPropName must be added to the propsData map")
//            }
//            plainData.asDynamic()[it] = data[it]
//        }
//
//    return plainData
//}
//
//
//fun forwardStaticMembers(
//    extendedComponent: types.vue.external_declarations.vue.ExtendedVue<types.vue.external_declarations.vue.Vue>,
//    vComponent: JsClass<out external_declarations.vue.Component>,
//    componentOptions: types.vue.external_declarations.vue.ComponentOptions
//) {
//    val reservedPropertyNames = arrayOf(
//// Unique id
//        "cid",
//
//// Super types.vue.external_declarations.vue.Vue constructor
//        "super",
//
//// external_declarations.vue.Component options that will be used by the component
//        "options",
//        "superOptions",
//        "extendOptions",
//        "sealedOptions",
//
//// Private assets
//        "component",
//        "directive",
//        "filter"
//    )
//
//    val shouldIgnore = arrayOf(
//        "\$metadata\$",
//        "prototype",
//        "arguments",
//        "callee",
//        "caller"
//    )
//
//    Object.getOwnPropertyNames(vComponent).forEach keys@{ key ->
//
//        // Skip the properties that should not be overwritten
//        if (shouldIgnore.contains(key)) {
//            return@keys
//        }
//
//        // Some browsers does not allow reconfigure built-in properties
//        val extendedDescriptor = Object.getOwnPropertyDescriptor<Any>(extendedComponent, key)
//
//        @Suppress("SENSELESS_COMPARISON") // TODO remove when Object interface is updated.
//        if (extendedDescriptor != null && !extendedDescriptor.configurable) {
//            return@keys
//        }
//
//        // Warn if the users manually declare reserved properties
//        if (js("process.env.NODE_ENV !== 'production'").unsafeCast<Boolean>() && reservedPropertyNames.contains(key)) {
//
//            console.warn(
//                "Static property name '${key}' declared on class '${vComponent.name}' " +
//                        "conflicts with reserved property name of types.vue.external_declarations.vue.Vue internal. " +
//                        "It may cause unexpected behavior of the component. Consider renaming the property."
//            )
//        }
//
//        val descriptor = Object.getOwnPropertyDescriptor<Any>(vComponent, key)
//
//        if (key === "name") {
//            if (componentOptions.name == null) {
//                throw Error("A component name must be set")
//            }
//            descriptor.value = componentOptions.name!!
//        }
//
//        Object.defineProperty(extendedComponent, key, descriptor)
//    }
//}
