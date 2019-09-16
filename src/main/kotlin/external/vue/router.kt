@file:Suppress("unused")

package external.vue


import kotlin.js.RegExp

external interface Dictionary<T>

inline operator fun <T> Dictionary<T>.get(key: String): T? = asDynamic()[key].unsafeCast<T?>()

inline operator fun <T> Dictionary<T>.set(key: String, value: T) {
    asDynamic()[key] = value
}

typealias ErrorHandler = (err: Error) -> Unit

typealias NavigationGuard = (to: Route, from: Route, next: Next) -> Any

interface Next

fun Next.invoke(to: String) {
    return asDynamic()(to).unsafeCast<Unit>()
}

fun Next.invoke(to: Location) {
    return asDynamic()(to).unsafeCast<Unit>()
}

fun Next.invoke(to: Boolean) {
    return asDynamic()(to).unsafeCast<Unit>()
}

fun Next.invoke(to: (vm: Vue) -> Any) {
    return asDynamic()(to).unsafeCast<Unit>()
}

external interface Resolved {
    var location: Location
    var route: Route
    var href: String
    var normalizedTo: Location
    var resolved: Route
}


external interface Position {
    var x: Number
    var y: Number
}

external interface PositionResult {
    var selector: String
    var offset: Position? get() = definedExternally; set(value) = definedExternally
}

external interface RouterOptions {
    var routes: Array<RouteConfig>? get() = definedExternally; set(value) = definedExternally
    var mode: dynamic /* 'hash' | 'history' | 'abstract' */ get() = definedExternally; set(value) = definedExternally
    var fallback: Boolean? get() = definedExternally; set(value) = definedExternally
    var base: String? get() = definedExternally; set(value) = definedExternally
    var linkActiveClass: String? get() = definedExternally; set(value) = definedExternally
    var linkExactActiveClass: String? get() = definedExternally; set(value) = definedExternally
    var parseQuery: ((query: String) -> Any)? get() = definedExternally; set(value) = definedExternally
    var stringifyQuery: ((query: Any) -> String)? get() = definedExternally; set(value) = definedExternally
    var scrollBehavior: ((to: Route, from: Route, savedPosition: dynamic /* Position | Unit */) -> dynamic /* PositionResult | Promise<PositionResult> */)? get() = definedExternally; set(value) = definedExternally
}

typealias RoutePropsFunction = (route: Route) -> Any

external interface PathToRegexpOptions {
    var sensitive: Boolean? get() = definedExternally; set(value) = definedExternally
    var strict: Boolean? get() = definedExternally; set(value) = definedExternally
    var end: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface RouteConfig {
    var path: String? get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var component: dynamic /* ComponentOptions<Vue> | Any | AsyncComponent */ get() = definedExternally; set(value) = definedExternally
    var components: dynamic /* Dictionary<dynamic  ComponentOptions<Vue> | Any | AsyncComponent>? */ get() = definedExternally; set(value) = definedExternally
    var redirect: dynamic /* String | Location | (to: Route) -> dynamic */ get() = definedExternally; set(value) = definedExternally
    var alias: dynamic /* String | Array<String> */ get() = definedExternally; set(value) = definedExternally
    var children: Array<RouteConfig>? get() = definedExternally; set(value) = definedExternally
    var meta: Any? get() = definedExternally; set(value) = definedExternally
    var beforeEnter: NavigationGuard? get() = definedExternally; set(value) = definedExternally
    var props: dynamic /* Boolean | Any | RoutePropsFunction */ get() = definedExternally; set(value) = definedExternally
    var caseSensitive: Boolean? get() = definedExternally; set(value) = definedExternally
    var pathToRegexpOptions: PathToRegexpOptions? get() = definedExternally; set(value) = definedExternally
}

external interface RouteRecord {
    var path: String
    var regex: RegExp
    var components: Dictionary<dynamic /* ComponentOptions<Vue> | Any | AsyncComponent */>
    var instances: Dictionary<Vue>
    var name: String? get() = definedExternally; set(value) = definedExternally
    var parent: RouteRecord? get() = definedExternally; set(value) = definedExternally
    var redirect: dynamic /* String | Location | (to: Route) -> dynamic */
    var matchAs: String? get() = definedExternally; set(value) = definedExternally
    var meta: Any
    var beforeEnter: ((route: Route, redirect: (location: dynamic /* String | Location */) -> Unit, next: () -> Unit) -> Any)? get() = definedExternally; set(value) = definedExternally
    var props: dynamic /* Boolean | Any | RoutePropsFunction | Dictionary<dynamic /* Boolean | Any | RoutePropsFunction */> */
}

external interface Location {
    var name: String? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var hash: String? get() = definedExternally; set(value) = definedExternally
    var query: dynamic /* Dictionary<dynamic  String | Array<String?> | Nothing? | Nothing?>? */ get() = definedExternally; set(value) = definedExternally
    var params: dynamic /* Dictionary<String>? */ get() = definedExternally; set(value) = definedExternally
    var append: Boolean? get() = definedExternally; set(value) = definedExternally
    var replace: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface Route {
    var path: String
    var name: String? get() = definedExternally; set(value) = definedExternally
    var hash: String
    var query: Dictionary<dynamic /* String | Array<String?> */>
    var params: Dictionary<String>
    var fullPath: String
    var matched: Array<RouteRecord>
    var redirectedFrom: String? get() = definedExternally; set(value) = definedExternally
    var meta: Any? get() = definedExternally; set(value) = definedExternally
}
