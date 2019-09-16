@file:Suppress("unused")

package wrapper

import org.w3c.dom.events.Event

/**
 * ts type - { [key: string]: Function | Function[] }
 */
external interface OnEvents

typealias EventCallback <R> = (event: Event) -> R
typealias EventCallbacksBuilder <R> = ArrayList<EventCallback<R>>.() -> Unit

inline operator fun <R> OnEvents.get(key: String): EventCallback<R> =
    asDynamic()[key].unsafeCast<EventCallback<R>>()

inline operator fun <R> OnEvents.set(key: String, noinline value: EventCallback<R>) {
    asDynamic()[key] = value
}

inline operator fun <R> OnEvents.set(key: String, value: Array<EventCallback<R>>) {
    asDynamic()[key] = value
}


open class VWebEvents : OnEvents {


    fun <R> VNodeDataBuilder<*, *, *>.change(callback: EventCallback<R>) = addOnEvent("change", callback)
    fun VNodeDataBuilder<*, *, *>.changeArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("change", builder)

    fun <R> VNodeDataBuilder<*, *, *>.input(callback: EventCallback<R>) = addOnEvent("input", callback)
    fun VNodeDataBuilder<*, *, *>.inputArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("input", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Media_events
     */
    fun <R> VNodeDataBuilder<*, *, *>.waiting(callback: EventCallback<R>) = addOnEvent("waiting", callback)

    fun VNodeDataBuilder<*, *, *>.waitingArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("waiting", builder)

    fun <R> VNodeDataBuilder<*, *, *>.volumechange(callback: EventCallback<R>) = addOnEvent("volumechange", callback)
    fun VNodeDataBuilder<*, *, *>.volumechangeArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("volumechange", builder)

    fun <R> VNodeDataBuilder<*, *, *>.timeupdate(callback: EventCallback<R>) = addOnEvent("timeupdate", callback)
    fun VNodeDataBuilder<*, *, *>.timeupdateArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("timeupdate", builder)

    fun <R> VNodeDataBuilder<*, *, *>.suspend(callback: EventCallback<R>) = addOnEvent("suspend", callback)
    fun VNodeDataBuilder<*, *, *>.suspendArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("suspend", builder)

    fun <R> VNodeDataBuilder<*, *, *>.stalled(callback: EventCallback<R>) = addOnEvent("stalled", callback)
    fun VNodeDataBuilder<*, *, *>.stalledArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("stalled", builder)

    fun <R> VNodeDataBuilder<*, *, *>.seeking(callback: EventCallback<R>) = addOnEvent("seeking", callback)
    fun VNodeDataBuilder<*, *, *>.seekingArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("seeking", builder)

    fun <R> VNodeDataBuilder<*, *, *>.seeked(callback: EventCallback<R>) = addOnEvent("seeked", callback)
    fun VNodeDataBuilder<*, *, *>.seekedArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("seeked", builder)

    fun <R> VNodeDataBuilder<*, *, *>.ratechange(callback: EventCallback<R>) = addOnEvent("ratechange", callback)
    fun VNodeDataBuilder<*, *, *>.ratechangeArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("ratechange", builder)

    fun <R> VNodeDataBuilder<*, *, *>.playing(callback: EventCallback<R>) = addOnEvent("playing", callback)
    fun VNodeDataBuilder<*, *, *>.playingArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("playing", builder)

    fun <R> VNodeDataBuilder<*, *, *>.play(callback: EventCallback<R>) = addOnEvent("play", callback)
    fun VNodeDataBuilder<*, *, *>.playArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("play", builder)

    fun <R> VNodeDataBuilder<*, *, *>.pause(callback: EventCallback<R>) = addOnEvent("pause", callback)
    fun VNodeDataBuilder<*, *, *>.pauseArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("pause", builder)

    fun <R> VNodeDataBuilder<*, *, *>.loadedmetadata(callback: EventCallback<R>) =
        addOnEvent("loadedmetadata", callback)

    fun VNodeDataBuilder<*, *, *>.loadedmetadataArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("loadedmetadata", builder)

    fun <R> VNodeDataBuilder<*, *, *>.loadeddata(callback: EventCallback<R>) = addOnEvent("loadeddata", callback)
    fun VNodeDataBuilder<*, *, *>.loadeddataArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("loadeddata", builder)

    fun <R> VNodeDataBuilder<*, *, *>.ended(callback: EventCallback<R>) = addOnEvent("ended", callback)
    fun VNodeDataBuilder<*, *, *>.endedArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("ended", builder)

    fun <R> VNodeDataBuilder<*, *, *>.emptied(callback: EventCallback<R>) = addOnEvent("emptied", callback)
    fun VNodeDataBuilder<*, *, *>.emptiedArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("emptied", builder)

    fun <R> VNodeDataBuilder<*, *, *>.durationchange(callback: EventCallback<R>) =
        addOnEvent("durationchange", callback)

    fun VNodeDataBuilder<*, *, *>.durationchangeArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("durationchange", builder)

    fun <R> VNodeDataBuilder<*, *, *>.complete(callback: EventCallback<R>) = addOnEvent("complete", callback)
    fun VNodeDataBuilder<*, *, *>.completeArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("complete", builder)

    fun <R> VNodeDataBuilder<*, *, *>.canplaythrough(callback: EventCallback<R>) =
        addOnEvent("canplaythrough", callback)

    fun VNodeDataBuilder<*, *, *>.canplaythroughArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("canplaythrough", builder)

    fun <R> VNodeDataBuilder<*, *, *>.canplay(callback: EventCallback<R>) = addOnEvent("canplay", callback)
    fun VNodeDataBuilder<*, *, *>.canplayArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("canplay", builder)

    fun <R> VNodeDataBuilder<*, *, *>.audioprocess(callback: EventCallback<R>) = addOnEvent("audioprocess", callback)
    fun VNodeDataBuilder<*, *, *>.audioprocessArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("audioprocess", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Drag_Drop_events
     */
    fun <R> VNodeDataBuilder<*, *, *>.drop(callback: EventCallback<R>) = addOnEvent("drop", callback)

    fun VNodeDataBuilder<*, *, *>.dropArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("drop", builder)

    fun <R> VNodeDataBuilder<*, *, *>.dragover(callback: EventCallback<R>) = addOnEvent("dragover", callback)
    fun VNodeDataBuilder<*, *, *>.dragoverArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("dragover", builder)

    fun <R> VNodeDataBuilder<*, *, *>.dragleave(callback: EventCallback<R>) = addOnEvent("dragleave", callback)
    fun VNodeDataBuilder<*, *, *>.dragleaveArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("dragleave", builder)

    fun <R> VNodeDataBuilder<*, *, *>.dragstart(callback: EventCallback<R>) = addOnEvent("dragstart", callback)
    fun VNodeDataBuilder<*, *, *>.dragstartArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("dragstart", builder)

    fun <R> VNodeDataBuilder<*, *, *>.dragenter(callback: EventCallback<R>) = addOnEvent("dragenter", callback)
    fun VNodeDataBuilder<*, *, *>.dragenterArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("dragenter", builder)

    fun <R> VNodeDataBuilder<*, *, *>.dragend(callback: EventCallback<R>) = addOnEvent("dragend", callback)
    fun VNodeDataBuilder<*, *, *>.dragendArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("dragend", builder)

    fun <R> VNodeDataBuilder<*, *, *>.drag(callback: EventCallback<R>) = addOnEvent("drag", callback)
    fun VNodeDataBuilder<*, *, *>.dragArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("drag", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Mouse_events
     */
    fun <R> VNodeDataBuilder<*, *, *>.wheel(callback: EventCallback<R>) = addOnEvent("wheel", callback)

    fun VNodeDataBuilder<*, *, *>.wheelArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("wheel", builder)

    fun <R> VNodeDataBuilder<*, *, *>.select(callback: EventCallback<R>) = addOnEvent("select", callback)
    fun VNodeDataBuilder<*, *, *>.selectArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("select", builder)

    fun <R> VNodeDataBuilder<*, *, *>.pointerlockerror(callback: EventCallback<R>) =
        addOnEvent("pointerlockerror", callback)

    fun VNodeDataBuilder<*, *, *>.pointerlockerrorArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("pointerlockerror", builder)

    fun <R> VNodeDataBuilder<*, *, *>.pointerlockchange(callback: EventCallback<R>) =
        addOnEvent("pointerlockchange", callback)

    fun VNodeDataBuilder<*, *, *>.pointerlockchangeArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("pointerlockchange", builder)

    fun <R> VNodeDataBuilder<*, *, *>.mouseup(callback: EventCallback<R>) = addOnEvent("mouseup", callback)
    fun VNodeDataBuilder<*, *, *>.mouseupArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("mouseup", builder)

    fun <R> VNodeDataBuilder<*, *, *>.mouseout(callback: EventCallback<R>) = addOnEvent("mouseout", callback)
    fun VNodeDataBuilder<*, *, *>.mouseoutArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("mouseout", builder)

    fun <R> VNodeDataBuilder<*, *, *>.mouseover(callback: EventCallback<R>) = addOnEvent("mouseover", callback)
    fun VNodeDataBuilder<*, *, *>.mouseoverArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("mouseover", builder)

    fun <R> VNodeDataBuilder<*, *, *>.mousemove(callback: EventCallback<R>) = addOnEvent("mousemove", callback)
    fun VNodeDataBuilder<*, *, *>.mousemoveArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("mousemove", builder)

    fun <R> VNodeDataBuilder<*, *, *>.mouseleave(callback: EventCallback<R>) = addOnEvent("mouseleave", callback)
    fun VNodeDataBuilder<*, *, *>.mouseleaveArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("mouseleave", builder)

    fun <R> VNodeDataBuilder<*, *, *>.mouseenter(callback: EventCallback<R>) = addOnEvent("mouseenter", callback)
    fun VNodeDataBuilder<*, *, *>.mouseenterArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("mouseenter", builder)

    fun <R> VNodeDataBuilder<*, *, *>.mousedown(callback: EventCallback<R>) = addOnEvent("mousedown", callback)
    fun VNodeDataBuilder<*, *, *>.mousedownArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("mousedown", builder)

    fun <R> VNodeDataBuilder<*, *, *>.dblclick(callback: EventCallback<R>) = addOnEvent("dblclick", callback)
    fun VNodeDataBuilder<*, *, *>.dblclickArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("dblclick", builder)

    fun <R> VNodeDataBuilder<*, *, *>.contextmenu(callback: EventCallback<R>) = addOnEvent("contextmenu", callback)
    fun VNodeDataBuilder<*, *, *>.contextmenuArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("contextmenu", builder)

    fun <R> VNodeDataBuilder<*, *, *>.click(callback: EventCallback<R>) = addOnEvent("click", callback)
    fun VNodeDataBuilder<*, *, *>.clickArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("click", builder)

    fun <R> VNodeDataBuilder<*, *, *>.auxclick(callback: EventCallback<R>) = addOnEvent("auxclick", callback)
    fun VNodeDataBuilder<*, *, *>.auxclickArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("auxclick", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Keyboard_events
     */
    fun <R> VNodeDataBuilder<*, *, *>.keyup(callback: EventCallback<R>) = addOnEvent("keyup", callback)

    fun VNodeDataBuilder<*, *, *>.keyupArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("keyup", builder)

    fun <R> VNodeDataBuilder<*, *, *>.keypress(callback: EventCallback<R>) = addOnEvent("keypress", callback)
    fun VNodeDataBuilder<*, *, *>.keypressArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("keypress", builder)

    fun <R> VNodeDataBuilder<*, *, *>.keydown(callback: EventCallback<R>) = addOnEvent("keydown", callback)
    fun VNodeDataBuilder<*, *, *>.keydownArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("keydown", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Clipboard_events
     */
    fun <R> VNodeDataBuilder<*, *, *>.paste(callback: EventCallback<R>) = addOnEvent("paste", callback)

    fun VNodeDataBuilder<*, *, *>.pasteArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("paste", builder)

    fun <R> VNodeDataBuilder<*, *, *>.copy(callback: EventCallback<R>) = addOnEvent("copy", callback)
    fun VNodeDataBuilder<*, *, *>.copyArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("copy", builder)

    fun <R> VNodeDataBuilder<*, *, *>.cut(callback: EventCallback<R>) = addOnEvent("cut", callback)
    fun VNodeDataBuilder<*, *, *>.cutArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("cut", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#View_events
     */
    fun <R> VNodeDataBuilder<*, *, *>.scroll(callback: EventCallback<R>) = addOnEvent("scroll", callback)

    fun VNodeDataBuilder<*, *, *>.scrollArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("scroll", builder)

    fun <R> VNodeDataBuilder<*, *, *>.resize(callback: EventCallback<R>) = addOnEvent("resize", callback)
    fun VNodeDataBuilder<*, *, *>.resizeArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("resize", builder)

    fun <R> VNodeDataBuilder<*, *, *>.fullscreenerror(callback: EventCallback<R>) =
        addOnEvent("fullscreenerror", callback)

    fun VNodeDataBuilder<*, *, *>.fullscreenerrorArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("fullscreenerror", builder)

    fun <R> VNodeDataBuilder<*, *, *>.fullscreenchange(callback: EventCallback<R>) =
        addOnEvent("fullscreenchange", callback)

    fun VNodeDataBuilder<*, *, *>.fullscreenchangeArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("fullscreenchange", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Focus_events
     */
    fun <R> VNodeDataBuilder<*, *, *>.focus(callback: EventCallback<R>) = addOnEvent("focus", callback)

    fun VNodeDataBuilder<*, *, *>.focusArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("focus", builder)

    fun <R> VNodeDataBuilder<*, *, *>.blur(callback: EventCallback<R>) = addOnEvent("blur", callback)
    fun VNodeDataBuilder<*, *, *>.blurArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("blur", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Form_events
     */
    fun <R> VNodeDataBuilder<*, *, *>.submit(callback: EventCallback<R>) = addOnEvent("submit", callback)

    fun VNodeDataBuilder<*, *, *>.submitArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("submit", builder)

    fun <R> VNodeDataBuilder<*, *, *>.reset(callback: EventCallback<R>) = addOnEvent("reset", callback)
    fun VNodeDataBuilder<*, *, *>.resetArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("reset", builder)
}


