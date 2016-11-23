package org.jetbrains.kstats

import kotlinx.html.*


fun FlowContent.dashboard() {
    TitleManager.title = "Dashboard"
    header {
        navbar()
    }
    div {
        div("row") {
            div("col s12 m6") {
                cardPanel {
                    div { id = "kotlinCommitsVsAll" }
                    postInit {
                        js("dateAreaChart()")
                    }
                }
            }
            div("col s12 m6") {
                cardPanel {
                    +"GRAPH HERE"
                }
            }
        }
    }
}



fun FlowContent.navbar() {
    nav {
        div("nav-wrapper") {
            div("row") {
                div("col s12") {
                    a("/", classes = "brand-logo") {
                        img { src = "/img/logo.png" }
                        +"Internal Usage Statistics"
                    }
                }
            }
        }
    }
}

fun FlowContent.cardPanel(body: FlowContent.() -> Unit) {
    div("card-panel") { body() }
}