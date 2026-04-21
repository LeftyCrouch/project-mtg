package com.crouch.projectmtg.shared.core.logger

actual object Logger {
    actual fun verbose(tag: String, message: () -> String) {
        //TODO
    }

    actual fun debug(tag: String, message: () -> String) {
        //TODO
    }

    actual fun info(tag: String, message: () -> String) {
        //TODO
    }

    actual fun warn(tag: String, message: () -> String) {
        //TODO
    }

    actual fun error(
        tag: String,
        throwable: Throwable?,
        message: () -> String
    ) {
        //TODO
    }
}