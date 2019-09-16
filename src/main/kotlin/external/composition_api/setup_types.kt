package external.composition_api

import external.vue.VNode

interface Slot

operator fun Slot.invoke(args: Array<Any>? = null): VNode {
    return asDynamic()(args).unsafeCast<VNode>()
}


typealias RenderFunction = () -> VNode

typealias SetupFunction<Props> = (props: Props, ctx: SetupContext) -> RenderFunction

