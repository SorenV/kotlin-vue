@file:Suppress("unused")

package wrapper

import external.composition_api.createElement
import external.vue.VNode
import external.vue.invoke
import kotlinext.js.jsObject
import kotlinx.html.*
import org.w3c.dom.*

fun <A : HTMLTag, D : HTMLElement> VRender<*, *, *>.tag(
    tag: String,
    attrs: A,
    render: VRender<Unit, A, D>.() -> Unit
): VNode {
    val vNodeData = VRender<Unit, A, D>().apply(render)

    vNodeData.attributeBuilder?.let {
        if (vNodeData.attrs == null) {
            vNodeData.attrs = jsObject { }
        }
        attrs.apply(it).attributesEntries.forEach { attr ->
            vNodeData.attrs.asDynamic()[attr.key] = attr.value
        }
    }
    vNodeData.domPropsBuilder?.let { vNodeData.domProps = jsObject(it) }

    val vNode = createElement(tag, vNodeData, vNodeData.getChildren())
    child(vNode)
    return vNode
}


fun VRender<*, *, *>.a(render: VRender<Unit, A, HTMLAnchorElement>.() -> Unit): VNode =
    tag("a", A(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.abbr(render: VRender<Unit, ABBR, HTMLElement>.() -> Unit): VNode =
    tag("abbr", ABBR(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.address(render: VRender<Unit, ADDRESS, HTMLElement>.() -> Unit): VNode =
    tag("address", ADDRESS(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.area(render: VRender<Unit, AREA, HTMLAreaElement>.() -> Unit): VNode =
    tag("area", AREA(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.article(render: VRender<Unit, ARTICLE, HTMLElement>.() -> Unit): VNode =
    tag("article", ARTICLE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.aside(render: VRender<Unit, ASIDE, HTMLElement>.() -> Unit): VNode =
    tag("aside", ASIDE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.audio(render: VRender<Unit, AUDIO, HTMLElement>.() -> Unit): VNode =
    tag("audio", AUDIO(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.b(render: VRender<Unit, B, HTMLElement>.() -> Unit): VNode =
    tag("b", B(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.base(render: VRender<Unit, BASE, HTMLBaseElement>.() -> Unit): VNode =
    tag("base", BASE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.bdi(render: VRender<Unit, BDI, HTMLElement>.() -> Unit): VNode =
    tag("bdi", BDI(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.bdo(render: VRender<Unit, BDO, HTMLElement>.() -> Unit): VNode =
    tag("bdo", BDO(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.blockQuote(render: VRender<Unit, BLOCKQUOTE, HTMLQuoteElement>.() -> Unit): VNode =
    tag("blockQuote", BLOCKQUOTE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.body(render: VRender<Unit, BODY, HTMLBodyElement>.() -> Unit): VNode =
    tag("body", BODY(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.br(render: VRender<Unit, BR, HTMLBRElement>.() -> Unit): VNode =
    tag("br", BR(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.button(render: VRender<Unit, BUTTON, HTMLButtonElement>.() -> Unit): VNode =
    tag("button", BUTTON(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.canvas(render: VRender<Unit, CANVAS, HTMLCanvasElement>.() -> Unit): VNode =
    tag("canvas", CANVAS(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.caption(render: VRender<Unit, CAPTION, HTMLTableCaptionElement>.() -> Unit): VNode =
    tag("caption", CAPTION(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.cite(render: VRender<Unit, CITE, HTMLElement>.() -> Unit): VNode =
    tag("cite", CITE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.code(render: VRender<Unit, CODE, HTMLElement>.() -> Unit): VNode =
    tag("code", CODE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.col(render: VRender<Unit, COL, HTMLTableColElement>.() -> Unit): VNode =
    tag("col", COL(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.colGroup(render: VRender<Unit, COLGROUP, HTMLTableColElement>.() -> Unit): VNode =
    tag("colGroup", COLGROUP(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.dataList(render: VRender<Unit, DATALIST, HTMLDataListElement>.() -> Unit): VNode =
    tag("dataList", DATALIST(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.dd(render: VRender<Unit, DD, HTMLElement>.() -> Unit): VNode =
    tag("dd", DD(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.del(render: VRender<Unit, DEL, HTMLModElement>.() -> Unit): VNode =
    tag("del", DEL(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.details(render: VRender<Unit, DETAILS, HTMLDetailsElement>.() -> Unit): VNode =
    tag("details", DETAILS(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.dfn(render: VRender<Unit, DFN, HTMLElement>.() -> Unit): VNode =
    tag("dfn", DFN(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.dialog(render: VRender<Unit, DIALOG, HTMLDialogElement>.() -> Unit): VNode =
    tag("dialog", DIALOG(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.div(render: VRender<Unit, DIV, HTMLDivElement>.() -> Unit): VNode =
    tag("div", DIV(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.dl(render: VRender<Unit, DL, HTMLDListElement>.() -> Unit): VNode =
    tag("dl", DL(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.dt(render: VRender<Unit, DT, HTMLElement>.() -> Unit): VNode =
    tag("dt", DT(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.em(render: VRender<Unit, EM, HTMLElement>.() -> Unit): VNode =
    tag("em", EM(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.embed(render: VRender<Unit, EMBED, HTMLEmbedElement>.() -> Unit): VNode =
    tag("embed", EMBED(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.fieldSet(render: VRender<Unit, FIELDSET, HTMLFieldSetElement>.() -> Unit): VNode =
    tag("fieldSet", FIELDSET(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.figcaption(render: VRender<Unit, FIGCAPTION, HTMLElement>.() -> Unit): VNode =
    tag("figcaption", FIGCAPTION(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.figure(render: VRender<Unit, FIGURE, HTMLElement>.() -> Unit): VNode =
    tag("figure", FIGURE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.footer(render: VRender<Unit, FOOTER, HTMLElement>.() -> Unit): VNode =
    tag("footer", FOOTER(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.form(render: VRender<Unit, FORM, HTMLFormElement>.() -> Unit): VNode =
    tag("form", FORM(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.h1(render: VRender<Unit, H1, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h1", H1(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.h2(render: VRender<Unit, H2, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h2", H2(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.h3(render: VRender<Unit, H3, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h3", H3(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.h4(render: VRender<Unit, H4, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h4", H4(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.h5(render: VRender<Unit, H5, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h5", H5(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.h6(render: VRender<Unit, H6, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h6", H6(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.head(render: VRender<Unit, HEAD, HTMLHeadElement>.() -> Unit): VNode =
    tag("head", HEAD(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.header(render: VRender<Unit, HEADER, HTMLElement>.() -> Unit): VNode =
    tag("header", HEADER(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.hGroup(render: VRender<Unit, HGROUP, HTMLElement>.() -> Unit): VNode =
    tag("hGroup", HGROUP(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.hr(render: VRender<Unit, HR, HTMLHRElement>.() -> Unit): VNode =
    tag("hr", HR(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.html(render: VRender<Unit, HTML, HTMLHtmlElement>.() -> Unit): VNode =
    tag("html", HTML(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.i(render: VRender<Unit, I, HTMLElement>.() -> Unit): VNode =
    tag("i", I(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.iframe(render: VRender<Unit, IFRAME, HTMLIFrameElement>.() -> Unit): VNode =
    tag("iframe", IFRAME(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.img(render: VRender<Unit, IMG, HTMLImageElement>.() -> Unit): VNode =
    tag("img", IMG(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.input(render: VRender<Unit, INPUT, HTMLInputElement>.() -> Unit): VNode =
    tag("input", INPUT(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.ins(render: VRender<Unit, INS, HTMLModElement>.() -> Unit): VNode =
    tag("ins", INS(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.kbd(render: VRender<Unit, KBD, HTMLElement>.() -> Unit): VNode =
    tag("kbd", KBD(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.label(render: VRender<Unit, LABEL, HTMLLabelElement>.() -> Unit): VNode =
    tag("label", LABEL(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.legend(render: VRender<Unit, LEGEND, HTMLLegendElement>.() -> Unit): VNode =
    tag("legend", LEGEND(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.li(render: VRender<Unit, LI, HTMLLIElement>.() -> Unit): VNode =
    tag("li", LI(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.link(render: VRender<Unit, LINK, HTMLLinkElement>.() -> Unit): VNode =
    tag("link", LINK(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.map(render: VRender<Unit, MAP, HTMLMapElement>.() -> Unit): VNode =
    tag("map", MAP(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.mark(render: VRender<Unit, MARK, HTMLElement>.() -> Unit): VNode =
    tag("mark", MARK(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.meta(render: VRender<Unit, META, HTMLMetaElement>.() -> Unit): VNode =
    tag("meta", META(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.meter(render: VRender<Unit, METER, HTMLMeterElement>.() -> Unit): VNode =
    tag("meter", METER(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.nav(render: VRender<Unit, NAV, HTMLElement>.() -> Unit): VNode =
    tag("nav", NAV(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.noScript(render: VRender<Unit, NOSCRIPT, HTMLElement>.() -> Unit): VNode =
    tag("noScript", NOSCRIPT(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.`object`(render: VRender<Unit, OBJECT, HTMLObjectElement>.() -> Unit): VNode =
    tag("object", OBJECT(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.ol(render: VRender<Unit, OL, HTMLOListElement>.() -> Unit): VNode =
    tag("ol", OL(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.optGroup(render: VRender<Unit, OPTGROUP, HTMLOptGroupElement>.() -> Unit): VNode =
    tag("optGroup", OPTGROUP(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.option(render: VRender<Unit, OPTION, HTMLOptionElement>.() -> Unit): VNode =
    tag("option", OPTION(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.output(render: VRender<Unit, OUTPUT, HTMLOutputElement>.() -> Unit): VNode =
    tag("output", OUTPUT(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.p(render: VRender<Unit, P, HTMLParagraphElement>.() -> Unit): VNode =
    tag("p", P(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.param(render: VRender<Unit, PARAM, HTMLParamElement>.() -> Unit): VNode =
    tag("param", PARAM(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.pre(render: VRender<Unit, PRE, HTMLPreElement>.() -> Unit): VNode =
    tag("pre", PRE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.progress(render: VRender<Unit, PROGRESS, HTMLProgressElement>.() -> Unit): VNode =
    tag("progress", PROGRESS(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.q(render: VRender<Unit, Q, HTMLQuoteElement>.() -> Unit): VNode =
    tag("q", Q(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.rp(render: VRender<Unit, RP, HTMLElement>.() -> Unit): VNode =
    tag("rp", RP(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.rt(render: VRender<Unit, RT, HTMLElement>.() -> Unit): VNode =
    tag("rt", RT(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.ruby(render: VRender<Unit, RUBY, HTMLElement>.() -> Unit): VNode =
    tag("ruby", RUBY(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.samp(render: VRender<Unit, SAMP, HTMLElement>.() -> Unit): VNode =
    tag("samp", SAMP(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.script(render: VRender<Unit, SCRIPT, HTMLScriptElement>.() -> Unit): VNode =
    tag("script", SCRIPT(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.section(render: VRender<Unit, SECTION, HTMLElement>.() -> Unit): VNode =
    tag("section", SECTION(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.select(render: VRender<Unit, SELECT, HTMLSelectElement>.() -> Unit): VNode =
    tag("select", SELECT(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.small(render: VRender<Unit, SMALL, HTMLElement>.() -> Unit): VNode =
    tag("small", SMALL(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.source(render: VRender<Unit, SOURCE, HTMLSourceElement>.() -> Unit): VNode =
    tag("source", SOURCE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.span(render: VRender<Unit, SPAN, HTMLSpanElement>.() -> Unit): VNode =
    tag("span", SPAN(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.strong(render: VRender<Unit, STRONG, HTMLSpanElement>.() -> Unit): VNode =
    tag("strong", STRONG(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.style(render: VRender<Unit, STYLE, HTMLSpanElement>.() -> Unit): VNode =
    tag("style", STYLE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.sub(render: VRender<Unit, SUB, HTMLElement>.() -> Unit): VNode =
    tag("sub", SUB(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.sup(render: VRender<Unit, SUP, HTMLElement>.() -> Unit): VNode =
    tag("sup", SUP(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.table(render: VRender<Unit, TABLE, HTMLTableElement>.() -> Unit): VNode =
    tag("table", TABLE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.tbody(render: VRender<Unit, TBODY, HTMLTableSectionElement>.() -> Unit): VNode =
    tag("tbody", TBODY(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.td(render: VRender<Unit, TD, HTMLTableCellElement>.() -> Unit): VNode =
    tag("td", TD(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.textArea(render: VRender<Unit, TEXTAREA, HTMLTextAreaElement>.() -> Unit): VNode =
    tag("textArea", TEXTAREA(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.tfoot(render: VRender<Unit, TFOOT, HTMLTableSectionElement>.() -> Unit): VNode =
    tag("tfoot", TFOOT(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.th(render: VRender<Unit, TH, HTMLTableCellElement>.() -> Unit): VNode =
    tag("th", TH(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.thead(render: VRender<Unit, THEAD, HTMLTableSectionElement>.() -> Unit): VNode =
    tag("thead", THEAD(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.time(render: VRender<Unit, TIME, HTMLTimeElement>.() -> Unit): VNode =
    tag("time", TIME(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.title(render: VRender<Unit, TITLE, HTMLTitleElement>.() -> Unit): VNode =
    tag("title", TITLE(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.tr(render: VRender<Unit, TR, HTMLTableRowElement>.() -> Unit): VNode =
    tag("tr", TR(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.ul(render: VRender<Unit, UL, HTMLUListElement>.() -> Unit): VNode =
    tag("ul", UL(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.`var`(render: VRender<Unit, VAR, HTMLElement>.() -> Unit): VNode =
    tag("var", VAR(mutableMapOf(), consumer), render)

fun VRender<*, *, *>.video(render: VRender<Unit, VIDEO, HTMLVideoElement>.() -> Unit): VNode =
    tag("video", VIDEO(mutableMapOf(), consumer), render)



