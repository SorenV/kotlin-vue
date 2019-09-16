import {Data} from "./setup";


export interface Ref<T> {
    value: T;
}


export declare function ref<T = undefined>(): Ref<T | undefined>;
export declare function ref<T = null>(raw: null): Ref<T | null>;
export declare function ref<T>(raw: T): Ref<T>;

export declare function isRef<T>(value: any): value is Ref<T>;

declare type Refs<Data> = {
    [K in keyof Data]: Data[K] extends Ref<infer V> ? Ref<V> : Ref<Data[K]>;
};

export declare function toRefs<T extends Data = Data>(obj: T): Refs<T>;

