package org.jetbrains.kstats

import kotlinx.html.FlowContent
import kotlinx.html.i


fun FlowContent.materialIcon(iconName: String, size: String = "large") {
    i(classes = "$size material-icons") { +iconName }
}