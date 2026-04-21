package com.crouch.projectmtg.shared.core.logger

object LogIt {
    var logLevel: LogLevel = LogLevel.INFO

    private val callbacks: MutableList<(String, String, Throwable?) -> Unit> = mutableListOf()

    fun addCallback(callback: (String, String, Throwable?) -> Unit) {
        callbacks.add(callback)
    }

    fun removeCallbacks() {
        callbacks.clear()
    }

    fun verbose(
        tag: String = formatTag(message::class.simpleName),
        message: () -> String
    ) {
        if (showLog(LogLevel.VERBOSE)) {
            Logger.verbose(tag, message)
            handleCallbacks(
                tag = tag,
                message = message
            )
        }
    }

    fun debug(
        tag: String = formatTag(message::class.simpleName),
        message: () -> String
    ) {
        if (showLog(LogLevel.DEBUG)) {
            Logger.debug(tag, message)
            handleCallbacks(
                tag = tag,
                message = message
            )
        }
    }

    fun info(
        tag: String = formatTag(message::class.simpleName),
        message: () -> String
    ) {
        if (showLog(LogLevel.INFO)) {
            Logger.info(tag, message)
            handleCallbacks(
                tag = tag,
                message = message
            )
        }
    }

    fun warn(
        tag: String = formatTag(message::class.simpleName),
        message: () -> String
    ) {
        if (showLog(LogLevel.WARN)) {
            Logger.warn(tag, message)
            handleCallbacks(
                tag = tag,
                message = message
            )
        }
    }

    fun error(
        tag: String = formatTag(message::class.simpleName),
        throwable: Throwable? = null,
        message: () -> String
    ) {
        if (showLog(LogLevel.ERROR)) {
            Logger.error(tag, throwable, message)
            handleCallbacks(tag, throwable, message)
        }
    }

    private fun handleCallbacks(
        tag: String = message::class.simpleName ?: "",
        throwable: Throwable? = null,
        message: () -> String
    ) {
        callbacks.forEach { callback ->
            callback.invoke(tag, message.invoke(), throwable)
        }
    }

    private fun formatTag(tag: String?): String {
        return tag?.let {
            it.split("$").firstOrNull() ?: ""
        } ?: ""
    }

    private fun showLog(logLevel: LogLevel) = logLevel.ordinal >= this.logLevel.ordinal
}