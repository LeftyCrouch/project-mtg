package com.crouch.projectmtg.shared.core.logger

import android.util.Log

actual object Logger {

    actual fun verbose(tag: String, message: () -> String) {
        Log.v(tag, message.invoke())
    }

    actual fun debug(tag: String, message: () -> String) {
        Log.d(tag, message.invoke())
    }

    actual fun info(tag: String, message: () -> String) {
        Log.i(tag, message.invoke())
    }

    actual fun warn(tag: String, message: () -> String) {
        Log.w(tag, message.invoke())
    }

    actual fun error(tag: String, throwable: Throwable?, message: () -> String) {
        Log.e(tag, message.invoke(), throwable)
    }
}