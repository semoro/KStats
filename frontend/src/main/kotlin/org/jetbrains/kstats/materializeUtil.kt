package org.jetbrains.kstats

import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.i


fun FlowContent.materialIcon(iconName: String, size: String = "large") {
    i(classes = "$size material-icons") { +iconName }
}

fun FlowContent.row(nested: FlowContent.() -> Unit) {
    div("row", nested)
}

fun FlowContent.col(s: Int? = null, m: Int? = null, l: Int? = null, nested: FlowContent.() -> Unit) {
    div(buildString {
        append("col ")
        s?.let { append("s$it ") }
        m?.let { append("m$it ") }
        l?.let { append("l$it ") }
    }, nested)
}