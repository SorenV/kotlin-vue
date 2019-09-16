@file:JsModule("vue-router")

package external.vue

import kotlin.js.Promise


@JsName("default")
open external class VueRouter(options: RouterOptions? = definedExternally) {
    open var app: Vue
    open var mode: String /* 'hash' | 'history' | 'abstract' */
    open var currentRoute: Route
    open fun beforeEach(guard: NavigationGuard): Function<*>
    open fun beforeResolve(guard: NavigationGuard): Function<*>
    open fun afterEach(hook: (to: Route, from: Route) -> Any): Function<*>
    open fun push(location: String): Promise<Route>
    open fun push(location: Location): Promise<Route>
    open fun replace(location: String): Promise<Route>
    open fun replace(location: Location): Promise<Route>
    open fun push(
        location: String,
        onComplete: Function<*>? = definedExternally,
        onAbort: ErrorHandler? = definedExternally
    )

    open fun push(
        location: Location,
        onComplete: Function<*>? = definedExternally,
        onAbort: ErrorHandler? = definedExternally
    )

    open fun replace(
        location: String,
        onComplete: Function<*>? = definedExternally,
        onAbort: ErrorHandler? = definedExternally
    )

    open fun replace(
        location: Location,
        onComplete: Function<*>? = definedExternally,
        onAbort: ErrorHandler? = definedExternally
    )

    open fun go(n: Number)
    open fun back()
    open fun forward()
    open fun getMatchedComponents(to: String? = definedExternally): Array<dynamic /* ComponentOptions<Vue> | Any | AsyncComponent */>
    open fun getMatchedComponents(to: Location? = definedExternally): Array<dynamic /* ComponentOptions<Vue> | Any | AsyncComponent */>
    open fun getMatchedComponents(to: Route? = definedExternally): Array<dynamic /* ComponentOptions<Vue> | Any | AsyncComponent */>
    open fun onReady(cb: Function<*>, errorCb: ErrorHandler? = definedExternally)
    open fun onError(cb: ErrorHandler)
    open fun addRoutes(routes: Array<RouteConfig>)
    open fun resolve(to: String, current: Route? = definedExternally, append: Boolean? = definedExternally): Resolved
    open fun resolve(to: Location, current: Route? = definedExternally, append: Boolean? = definedExternally): Resolved
    open fun getMatchedComponents(): Array<dynamic /* ComponentOptions<Vue> | Any | AsyncComponent */>

    companion object : PluginObject<Any> {
        override var install: PluginFunction<Any>
    }
}
