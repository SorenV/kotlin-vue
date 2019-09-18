@file:Suppress("unused")

package wrapper

import kotlinx.css.*
import org.w3c.dom.Element
import org.w3c.dom.css.CSSStyleSheet
import kotlin.browser.document


typealias VCssRuleSet = VCssBuilder.() -> Unit

open class VCssRule(open val selector: String, open val block: VCssRuleSet) {
    override fun toString(): String {
        val vCssBuilder = VCssBuilder().apply(block)

        if (vCssBuilder.rules.isNotEmpty()) {
            return buildString {
                append("$selector {")
                vCssBuilder.rules.forEach {
                    append(" $it")
                }
                append(" }")
            }
        }
        return buildRule(vCssBuilder)
    }

    private fun buildRule(vCssBuilder: VCssBuilder) = buildString {
        val declarationString = buildString {
            vCssBuilder.declarations.forEach {
                append("${it.key.hyphenize()}: ${it.value};")
            }
        }
        append("$selector { ")
        append(declarationString)
        append(" }")
    }
}


class VCssBuilder : StyledElement() {

    var styleName: String? = null

    var rules = mutableSetOf<VCssRule>()

    fun buildDeclarations(): String {
        return buildString {
            declarations.forEach {
                append("${it.key.hyphenize()}: ${it.value};")
            }
        }
    }

    override fun toString(): String {
        if (rules.isNotEmpty()) {
            return buildString {
                rules.forEach {
                    append("$it")
                }
            }
        }
        return ""
    }

    private fun rule(selector: String, block: VCssRuleSet): VCssRule {
        val rule = VCssRule(selector, block)
        rules.add(rule)
        return rule
    }

    operator fun VCssRuleSet.unaryPlus() {
        rules = VCssBuilder().apply(this).rules
    }

    operator fun String.invoke(block: VCssRuleSet) = rule(this, block)

    operator fun String.invoke(selector: String, block: VCssRuleSet) = rule(this + selector, block)

    operator fun TagSelector.invoke(block: VCssRuleSet) = tagName(block)

    operator fun TagSelector.invoke(selector: String, block: VCssRuleSet) = "$tagName$selector"(block)


    fun universal(block: VCssRuleSet) = "*"(block)


    fun media(query: String, block: VCssRuleSet) = "@media $query"(block)

    fun supports(query: String, block: VCssRuleSet) = "@supports $query"(block)

    fun fontFace(query: String, block: VCssRuleSet) = "@font-face $query"(block)


    fun active(selector: String = "") = "$selector:active"

    fun active(selector: String = "", block: VCssRuleSet) = "$selector:active"(block)

    fun checked(selector: String = "") = "$selector:checked"

    fun checked(selector: String = "", block: VCssRuleSet) = "$selector:checked"(block)

    fun default(selector: String = "") = "$selector:default"

    fun default(selector: String = "", block: VCssRuleSet) = "$selector:default"(block)

    fun disabled(selector: String = "") = "$selector:disabled"

    fun disabled(selector: String = "", block: VCssRuleSet) = "$selector:disabled"(block)

    fun empty(selector: String = "") = "$selector:empty"

    fun empty(selector: String = "", block: VCssRuleSet) = "$selector:empty"(block)

    fun firstChild(selector: String = "") = "$selector:first-child"

    fun firstChild(selector: String = "", block: VCssRuleSet) = "$selector:first-child"(block)

    fun firstOfType(selector: String = "") = "$selector:first-of-type"

    fun firstOfType(selector: String = "", block: VCssRuleSet) = "$selector:first-of-type"(block)

    fun focus(selector: String = "") = "$selector:focus"

    fun focus(selector: String = "", block: VCssRuleSet) = "$selector:focus"(block)

    fun hover(selector: String = "") = "$selector:hover"

    fun hover(selector: String = "", block: VCssRuleSet) = "$selector:hover"(block)

    fun indeterminate(selector: String = "") = "$selector:indeterminate"

    fun indeterminate(selector: String = "", block: VCssRuleSet) = "$selector:indeterminate"(block)

    fun inRange(selector: String = "") = "$selector:in-range"

    fun inRange(selector: String = "", block: VCssRuleSet) = "$selector:in-range"(block)

    fun invalid(selector: String = "") = "$selector:invalid"

    fun invalid(selector: String = "", block: VCssRuleSet) = "$selector:invalid"(block)

    fun lastChild(selector: String = "") = "$selector:last-child"

    fun lastChild(selector: String = "", block: VCssRuleSet) = "$selector:last-child"(block)

    fun link(selector: String = "") = "$selector:link"

    fun link(selector: String = "", block: VCssRuleSet) = "$selector:link"(block)

    fun onlyChild(selector: String = "") = "$selector:only-child"

    fun onlyChild(selector: String = "", block: VCssRuleSet) = "$selector:only-child"(block)

    fun onlyOfType(selector: String = "") = "$selector:only-of-type"

    fun onlyOfType(selector: String = "", block: VCssRuleSet) = "$selector:only-of-type"(block)

    fun optional(selector: String = "") = "$selector:optional"

    fun optional(selector: String = "", block: VCssRuleSet) = "$selector:optional"(block)

    fun outOfRange(selector: String = "") = "$selector:out-of-range"

    fun outOfRange(selector: String = "", block: VCssRuleSet) = "$selector:out-of-range"(block)

    fun readOnly(selector: String = "") = "$selector:read-only"

    fun readOnly(selector: String = "", block: VCssRuleSet) = "$selector:read-only"(block)

    fun readWrite(selector: String = "") = "$selector:read-write"

    fun readWrite(selector: String = "", block: VCssRuleSet) = "$selector:read-write"(block)

    fun required(selector: String = "") = "$selector:required"

    fun required(selector: String = "", block: VCssRuleSet) = "$selector:required"(block)

    fun valid(selector: String = "") = "$selector:valid"

    fun valid(selector: String = "", block: VCssRuleSet) = "$selector:valid"(block)

    fun visited(selector: String = "") = "$selector:visited"

    fun visited(selector: String = "", block: VCssRuleSet) = "$selector:visited"(block)


    fun nthOfType(selector: String = "") = ":nth-of-type($selector)"

    fun nthOfType(selector: String = "", block: VCssRuleSet) = ":nth-of-type($selector)"(block)

    fun nthChild(selector: String = "") = "nth-child($selector)"

    fun nthChild(selector: String = "", block: VCssRuleSet) = "nth-child($selector)"(block)

    fun nthLastChild(selector: String = "") = "nth-last-child($selector)"

    fun nthLastChild(selector: String = "", block: VCssRuleSet) = "nth-last-child($selector)"(block)

    fun nthLastOfType(selector: String = "") = "nth-last-of-type($selector)"

    fun nthLastOfType(selector: String = "", block: VCssRuleSet) = "nth-last-of-type($selector)"(block)


    fun not(selector: String) = ":not($selector)"

    fun not(selector: String, block: VCssRuleSet) = ":not($selector)"(block)


    fun children(selector: String? = null) = " > ${selector?.let { it } ?: "*"}"

    fun children(selector: String? = null, block: VCssRuleSet) = " > ${selector?.let { it } ?: "*"}"(block)

    fun descendants(selector: String? = null) = " ${selector?.let { it } ?: "*"}"

    fun descendants(selector: String? = null, block: VCssRuleSet) = " ${selector?.let { it } ?: "*"}"(block)


    fun child(selector: String) = "> $selector"

    fun child(selector: String, block: VCssRuleSet) = "> $selector"(block)

    fun sibling(selector: String) = "~ $selector"

    fun sibling(selector: String, block: VCssRuleSet) = "~ $selector"(block)

    fun adjacentSibling(selector: String) = "+ $selector"

    fun adjacentSibling(selector: String, block: VCssRuleSet) = "+ $selector"(block)


    fun placeholder() = "::placeholder"

    fun placeholder(block: VCssRuleSet) = "::placeholder"(block)

    fun after() = "::after"

    fun after(block: VCssRuleSet) = "::after" {
        content = "".quoted
        block()
    }

    fun before() = "::before"

    fun before(block: VCssRuleSet) = "::before" {
        content = "".quoted
        block()
    }
}

fun buildCss(css: VCssBuilder, name: String?) {

    if (name === null) {
        return
    }

    document.getElementById(name)?.let { return }

    val style: Element = document.createElement("style")

    style.id = name

    style.setAttribute("type", "text/css")

    document.head?.appendChild(style)

    val sheet = style.asDynamic().sheet.unsafeCast<CSSStyleSheet>()

    css.rules.withIndex().map {
        sheet.insertRule(it.value.toString(), it.index)
    }
}
