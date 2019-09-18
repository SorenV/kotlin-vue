@file:JsModule("@vue/composition-api")

package external.composition_api

external interface InjectionKey : Symbol

external fun <T> provide(key: Symbol, value: T)
external fun <T> provide(key: String, value: T)
external fun <T> inject(key: Symbol): Any? /* T | Unit */
external fun <T> inject(key: String): Any? /* T | Unit */
external fun <T> inject(key: Symbol, defaultValue: T): T
external fun <T> inject(key: String, defaultValue: T): T
