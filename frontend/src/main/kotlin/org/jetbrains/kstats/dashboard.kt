package org.jetbrains.kstats

import kotlinx.html.*


fun FlowContent.dashboard() {
    TitleManager.title = "Dashboard"
    header {
        navbar()
    }
    div {
        div("row") {
            div("col s12 l6") {
                cardPanel {
                    div(classes = "areaChart") { id = "kotlinCommitsVsAll" }
                    postInit {
                        Charts.mountDateAreaChart("/api/statistics/per_day/commits?days=7",
                                "#kotlinCommitsVsAll",
                                arrayOf("All commits", "Kotlin commits"))
                    }
                }
            }
            div("col s12 l6") {
                cardPanel {
                    div(classes = "areaChart") { id = "kotlinAuthorsVsAll" }
                    postInit {
                        Charts.mountDateAreaChart("/api/statistics/per_day/commiters?days=7",
                                "#kotlinAuthorsVsAll",
                                arrayOf("All commiters", "Kotlin commiters"))
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
                    ul(classes = "right hide-on-med-and-down") {
                        li {
                            materialIcon("settings")
                        }
                    }
                }
            }
        }
    }
}

fun FlowContent.cardPanel(body: FlowContent.() -> Unit) {
    div("card-panel") { body() }
}