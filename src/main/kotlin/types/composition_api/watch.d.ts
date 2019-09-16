import {Ref} from "./ref";

type StopHandle = () => void

type WatcherSource<T> = Ref<T> | (() => T)

type MapSources<T> = {
    [K in keyof T]: T[K] extends WatcherSource<infer V> ? V : never
}

type InvalidationRegister = (invalidate: () => void) => void

interface WatchOptions {
    lazy?: boolean
    flush?: 'pre' | 'post' | 'sync'
    deep?: boolean
}

// basic usage
declare function watch(
    effect: (onInvalidate: InvalidationRegister) => void,
    options?: WatchOptions
): StopHandle

// wacthing single source
declare function watch<T>(
    source: WatcherSource<T>,
    effect: (
        value: T,
        oldValue: T,
        onInvalidate: InvalidationRegister
    ) => void,
    options?: WatchOptions
): StopHandle

// watching multiple sources
declare function watch<T extends WatcherSource<unknown>[]>(
    sources: T,
    effect: (
        values: MapSources<T>,
        oldValues: MapSources<T>,
        onInvalidate: InvalidationRegister
    ) => void,
    options?: WatchOptions
): StopHandle
