package com.crouch.projectmtg.shared.core.logger

import android.util.Log

actual object Logger {

    actual fun verbose(tag: String, message: String) {
        Log.v(tag, message)
    }

    actual fun debug(tag: String, message: String) {
        Log.d(tag, message)
    }

    actual fun info(tag: String, message: String) {
        Log.i(tag, message)
    }

    actual fun warn(tag: String, message: String) {
        Log.w(tag, message)
    }

    actual fun error(tag: String, message: String, throwable: Throwable?) {
        Log.e(tag, message, throwable)
    }
}