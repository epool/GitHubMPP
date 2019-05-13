package dev.epool

import react.dom.render
import kotlin.browser.document
import kotlinext.js.require

fun main() {
    require("main.scss")
    document.addEventListener("DOMContentLoaded", {
        render(document.getElementById("root")) {
            app()
        }
    })
}