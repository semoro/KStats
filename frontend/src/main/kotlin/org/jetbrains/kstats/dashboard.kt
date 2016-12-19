package org.jetbrains.kstats

import kotlinx.html.*


fun FlowContent.dashboard() {
    TitleManager.title = "Dashboard"
    header {
        navbar()
    }
    div {
        row {
            col(s = 12, l = 6) {
                cardPanel {
                    div("areaChart") { id = "commits" }
                    postInit {
                        Charts.mountDateAreaChart("/api/statistics/per_day/commits",
                                "#commits",
                                arrayOf("All commits", "Kotlin commits"))
                    }
                }
            }
            col(s = 12, l = 6) {
                cardPanel {
                    div("areaChart") { id = "commiters" }
                    postInit {
                        Charts.mountDateAreaChart("/api/statistics/per_day/commiters",
                                "#commiters",
                                arrayOf("All commiters", "Kotlin commiters"))
                    }
                }
            }
        }
        div("row") {
            col(s = 12, l = 6) {
                cardPanel {
                    div("areaChart") { id = "vcsRoots" }
                    postInit {
                        Charts.mountDateAreaChart("/api/statistics/per_day/vcsRoots",
                                "#vcsRoots",
                                arrayOf("All projects", "Projects using Kotlin"))
                    }
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