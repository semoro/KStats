package org.jetbrains.kstats

import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlin.browser.document
import kotlin.dom.asList


object TitleManager {
    val titleElement = document.getElementsByTagName("title").asList().first()

    var title: String
        get() = titleElement.innerHTML
        set(value) {
            titleElement.innerHTML = value
        }
}


fun init() {
    val attachRoot = document.getElementById("attach-root")!!

    val element = document.create.div {
        dashboard()
    }
    attachRoot.replaceWith(element)
}



