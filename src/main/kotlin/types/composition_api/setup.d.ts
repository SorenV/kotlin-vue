import {VNode, VueConstructor} from "../vue";

declare function setup(
    props: Data,
    context: SetupContext
): Data

interface Data {
    [key: string]: unknown
}

export interface SetupContext {
    readonly attrs: Record<string, string>;
    readonly slots: {
        [key: string]: VNode[] | undefined;
    };
    readonly parent: ComponentInstance | null;
    readonly root: ComponentInstance;

    emit(event: string, ...args: any[]): void;
}

export declare type ComponentInstance = InstanceType<VueConstructor>;

declare type RenderFunction<Props> = (props: Props, ctx: SetupContext) => VNode;
export declare type SetupFunction<Props> = (this: void, props: Props, ctx: SetupContext) => RenderFunction<Props>;
