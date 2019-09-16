export declare const onCreated: (callback: Function) => void;
export declare const onBeforeMount: (callback: Function) => void;
export declare const onMounted: (callback: Function) => void;
export declare const onBeforeUpdate: (callback: Function) => void;
export declare const onUpdated: (callback: Function) => void;
export declare const onActivated: (callback: Function) => void;
export declare const onDeactivated: (callback: Function) => void;
export declare const onBeforeDestroy: (callback: Function) => void;
export declare const onDestroyed: (callback: Function) => void;
export declare const onErrorCaptured: (callback: Function) => void;
export declare const onUnmounted: (callback: Function) => void;


// not sure about these
export declare const onRenderTracked: (callback: Function) => void;
export declare const onRenderTriggered: (callback: Function) => void;


declare const plugin: {
    install: (Vue: VueConstructor<Vue>) => void;
};
