import {Ref} from "./ref";

declare function computed<T>(getter: () => T): Ref<T>

declare function computed<T>(options: {
    get: () => T,
    set: (value: T) => void
}): Ref<T>
