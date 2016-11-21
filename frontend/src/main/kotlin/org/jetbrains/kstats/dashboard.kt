package org.jetbrains.kstats

import kotlinx.html.*

fun FlowContent.dashboard() {
    TitleManager.title = "Dashboard"
    header {
        navbar()
    }
}



fun FlowContent.navbar() {
    nav {
        div("nav-wrapper") {
            a("/", "brand-logo") { +"Kotlin Internal Usage Statistics" }
        }
    }
}