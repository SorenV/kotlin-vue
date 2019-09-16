@file:JsModule("@vue/composition-api")

package external.composition_api

external interface Symbol {
    override fun toString(): String
    fun valueOf(): Any
}

external interface InjectionKey<T> : Symbol

external fun <T> provide(key: InjectionKey<T>, value: T)
external fun <T> provide(key: String, value: T)
external fun <T> inject(key: InjectionKey<T>): dynamic /* T | Unit */
external fun <T> inject(key: String): dynamic /* T | Unit */
external fun <T> inject(key: InjectionKey<T>, defaultValue: T): T
external fun <T> inject(key: String, defaultValue: T): T
