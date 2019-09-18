package external.composition_api

external interface Symbol {
    val description: String
}

inline operator fun Symbol.invoke(description: String): Symbol {
    return asDynamic()(description).unsafeCast<Symbol>()
}

@JsName("Symbol")
external val symbol: Symbol
