package uz.gita.gravitylabyrint.util

import timber.log.Timber

fun <T> T.scope(block: T.() -> Unit) {
    block(this)
}

fun myLog(message: String, tag: String = "TTT") {
    Timber.tag(tag).d(message)
}