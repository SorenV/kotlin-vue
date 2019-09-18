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

typealias VBuilder = VNodeDataBuilder<*, *, *>

open class VWebEvents : OnEvents {


    fun <R> VBuilder.change(callback: EventCallback<R>) = addOnEvent("change", callback)
    fun VBuilder.changeArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("change", builder)

    fun <R> VBuilder.input(callback: EventCallback<R>) = addOnEvent("input", callback)
    fun VBuilder.inputArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("input", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Media_events
     */
    fun <R> VBuilder.waiting(callback: EventCallback<R>) = addOnEvent("waiting", callback)

    fun VBuilder.waitingArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("waiting", builder)

    fun <R> VBuilder.volumechange(callback: EventCallback<R>) = addOnEvent("volumechange", callback)
    fun VBuilder.volumechangeArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("volumechange", builder)

    fun <R> VBuilder.timeupdate(callback: EventCallback<R>) = addOnEvent("timeupdate", callback)
    fun VBuilder.timeupdateArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("timeupdate", builder)

    fun <R> VBuilder.suspend(callback: EventCallback<R>) = addOnEvent("suspend", callback)
    fun VBuilder.suspendArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("suspend", builder)

    fun <R> VBuilder.stalled(callback: EventCallback<R>) = addOnEvent("stalled", callback)
    fun VBuilder.stalledArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("stalled", builder)

    fun <R> VBuilder.seeking(callback: EventCallback<R>) = addOnEvent("seeking", callback)
    fun VBuilder.seekingArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("seeking", builder)

    fun <R> VBuilder.seeked(callback: EventCallback<R>) = addOnEvent("seeked", callback)
    fun VBuilder.seekedArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("seeked", builder)

    fun <R> VBuilder.ratechange(callback: EventCallback<R>) = addOnEvent("ratechange", callback)
    fun VBuilder.ratechangeArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("ratechange", builder)

    fun <R> VBuilder.playing(callback: EventCallback<R>) = addOnEvent("playing", callback)
    fun VBuilder.playingArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("playing", builder)

    fun <R> VBuilder.play(callback: EventCallback<R>) = addOnEvent("play", callback)
    fun VBuilder.playArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("play", builder)

    fun <R> VBuilder.pause(callback: EventCallback<R>) = addOnEvent("pause", callback)
    fun VBuilder.pauseArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("pause", builder)

    fun <R> VBuilder.loadedmetadata(callback: EventCallback<R>) =
        addOnEvent("loadedmetadata", callback)

    fun VBuilder.loadedmetadataArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("loadedmetadata", builder)

    fun <R> VBuilder.loadeddata(callback: EventCallback<R>) = addOnEvent("loadeddata", callback)
    fun VBuilder.loadeddataArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("loadeddata", builder)

    fun <R> VBuilder.ended(callback: EventCallback<R>) = addOnEvent("ended", callback)
    fun VBuilder.endedArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("ended", builder)

    fun <R> VBuilder.emptied(callback: EventCallback<R>) = addOnEvent("emptied", callback)
    fun VBuilder.emptiedArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("emptied", builder)

    fun <R> VBuilder.durationchange(callback: EventCallback<R>) =
        addOnEvent("durationchange", callback)

    fun VBuilder.durationchangeArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("durationchange", builder)

    fun <R> VBuilder.complete(callback: EventCallback<R>) = addOnEvent("complete", callback)
    fun VBuilder.completeArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("complete", builder)

    fun <R> VBuilder.canplaythrough(callback: EventCallback<R>) =
        addOnEvent("canplaythrough", callback)

    fun VBuilder.canplaythroughArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("canplaythrough", builder)

    fun <R> VBuilder.canplay(callback: EventCallback<R>) = addOnEvent("canplay", callback)
    fun VBuilder.canplayArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("canplay", builder)

    fun <R> VBuilder.audioprocess(callback: EventCallback<R>) = addOnEvent("audioprocess", callback)
    fun VBuilder.audioprocessArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("audioprocess", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Drag_Drop_events
     */
    fun <R> VBuilder.drop(callback: EventCallback<R>) = addOnEvent("drop", callback)

    fun VBuilder.dropArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("drop", builder)

    fun <R> VBuilder.dragover(callback: EventCallback<R>) = addOnEvent("dragover", callback)
    fun VBuilder.dragoverArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("dragover", builder)

    fun <R> VBuilder.dragleave(callback: EventCallback<R>) = addOnEvent("dragleave", callback)
    fun VBuilder.dragleaveArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("dragleave", builder)

    fun <R> VBuilder.dragstart(callback: EventCallback<R>) = addOnEvent("dragstart", callback)
    fun VBuilder.dragstartArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("dragstart", builder)

    fun <R> VBuilder.dragenter(callback: EventCallback<R>) = addOnEvent("dragenter", callback)
    fun VBuilder.dragenterArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("dragenter", builder)

    fun <R> VBuilder.dragend(callback: EventCallback<R>) = addOnEvent("dragend", callback)
    fun VBuilder.dragendArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("dragend", builder)

    fun <R> VBuilder.drag(callback: EventCallback<R>) = addOnEvent("drag", callback)
    fun VBuilder.dragArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("drag", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Mouse_events
     */
    fun <R> VBuilder.wheel(callback: EventCallback<R>) = addOnEvent("wheel", callback)

    fun VBuilder.wheelArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("wheel", builder)

    fun <R> VBuilder.select(callback: EventCallback<R>) = addOnEvent("select", callback)
    fun VBuilder.selectArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("select", builder)

    fun <R> VBuilder.pointerlockerror(callback: EventCallback<R>) =
        addOnEvent("pointerlockerror", callback)

    fun VBuilder.pointerlockerrorArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("pointerlockerror", builder)

    fun <R> VBuilder.pointerlockchange(callback: EventCallback<R>) =
        addOnEvent("pointerlockchange", callback)

    fun VBuilder.pointerlockchangeArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("pointerlockchange", builder)

    fun <R> VBuilder.mouseup(callback: EventCallback<R>) = addOnEvent("mouseup", callback)
    fun VBuilder.mouseupArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("mouseup", builder)

    fun <R> VBuilder.mouseout(callback: EventCallback<R>) = addOnEvent("mouseout", callback)
    fun VBuilder.mouseoutArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("mouseout", builder)

    fun <R> VBuilder.mouseover(callback: EventCallback<R>) = addOnEvent("mouseover", callback)
    fun VBuilder.mouseoverArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("mouseover", builder)

    fun <R> VBuilder.mousemove(callback: EventCallback<R>) = addOnEvent("mousemove", callback)
    fun VBuilder.mousemoveArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("mousemove", builder)

    fun <R> VBuilder.mouseleave(callback: EventCallback<R>) = addOnEvent("mouseleave", callback)
    fun VBuilder.mouseleaveArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("mouseleave", builder)

    fun <R> VBuilder.mouseenter(callback: EventCallback<R>) = addOnEvent("mouseenter", callback)
    fun VBuilder.mouseenterArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("mouseenter", builder)

    fun <R> VBuilder.mousedown(callback: EventCallback<R>) = addOnEvent("mousedown", callback)
    fun VBuilder.mousedownArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("mousedown", builder)

    fun <R> VBuilder.dblclick(callback: EventCallback<R>) = addOnEvent("dblclick", callback)
    fun VBuilder.dblclickArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("dblclick", builder)

    fun <R> VBuilder.contextmenu(callback: EventCallback<R>) = addOnEvent("contextmenu", callback)
    fun VBuilder.contextmenuArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("contextmenu", builder)

    fun <R> VBuilder.click(callback: EventCallback<R>) = addOnEvent("click", callback)
    fun VBuilder.clickArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("click", builder)

    fun <R> VBuilder.auxclick(callback: EventCallback<R>) = addOnEvent("auxclick", callback)
    fun VBuilder.auxclickArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("auxclick", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Keyboard_events
     */
    fun <R> VBuilder.keyup(callback: EventCallback<R>) = addOnEvent("keyup", callback)

    fun VBuilder.keyupArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("keyup", builder)

    fun <R> VBuilder.keypress(callback: EventCallback<R>) = addOnEvent("keypress", callback)
    fun VBuilder.keypressArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("keypress", builder)

    fun <R> VBuilder.keydown(callback: EventCallback<R>) = addOnEvent("keydown", callback)
    fun VBuilder.keydownArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("keydown", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Clipboard_events
     */
    fun <R> VBuilder.paste(callback: EventCallback<R>) = addOnEvent("paste", callback)

    fun VBuilder.pasteArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("paste", builder)

    fun <R> VBuilder.copy(callback: EventCallback<R>) = addOnEvent("copy", callback)
    fun VBuilder.copyArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("copy", builder)

    fun <R> VBuilder.cut(callback: EventCallback<R>) = addOnEvent("cut", callback)
    fun VBuilder.cutArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("cut", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#View_events
     */
    fun <R> VBuilder.scroll(callback: EventCallback<R>) = addOnEvent("scroll", callback)

    fun VBuilder.scrollArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("scroll", builder)

    fun <R> VBuilder.resize(callback: EventCallback<R>) = addOnEvent("resize", callback)
    fun VBuilder.resizeArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("resize", builder)

    fun <R> VBuilder.fullscreenerror(callback: EventCallback<R>) =
        addOnEvent("fullscreenerror", callback)

    fun VBuilder.fullscreenerrorArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("fullscreenerror", builder)

    fun <R> VBuilder.fullscreenchange(callback: EventCallback<R>) =
        addOnEvent("fullscreenchange", callback)

    fun VBuilder.fullscreenchangeArray(builder: EventCallbacksBuilder<Any>) =
        addOnEvents("fullscreenchange", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Focus_events
     */
    fun <R> VBuilder.focus(callback: EventCallback<R>) = addOnEvent("focus", callback)

    fun VBuilder.focusArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("focus", builder)

    fun <R> VBuilder.blur(callback: EventCallback<R>) = addOnEvent("blur", callback)
    fun VBuilder.blurArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("blur", builder)


    /**
     * https://developer.mozilla.org/en-US/docs/Web/Events#Form_events
     */
    fun <R> VBuilder.submit(callback: EventCallback<R>) = addOnEvent("submit", callback)

    fun VBuilder.submitArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("submit", builder)

    fun <R> VBuilder.reset(callback: EventCallback<R>) = addOnEvent("reset", callback)
    fun VBuilder.resetArray(builder: EventCallbacksBuilder<Any>) = addOnEvents("reset", builder)
}


