@file:Suppress("unused")

package external.composition_api

enum class WatchFlushType(val value: String) {
    PRE("pre"),
    POST("post"),
    SYNC("sync"),
}

typealias StopHandle = () -> Unit
typealias MapSources<T> = Any
typealias InvalidationRegister = (invalidate: () -> Unit) -> Unit
