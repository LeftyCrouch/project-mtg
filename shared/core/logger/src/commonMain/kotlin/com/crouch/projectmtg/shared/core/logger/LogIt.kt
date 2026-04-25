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
            val invokedMessage = message.invoke()
            Logger.verbose(tag, invokedMessage)
            handleCallbacks(tag, invokedMessage)
        }
    }

    fun debug(
        tag: String = formatTag(message::class.simpleName),
        message: () -> String
    ) {
        if (showLog(LogLevel.DEBUG)) {
            val invokedMessage = message.invoke()
            Logger.debug(tag, invokedMessage)
            handleCallbacks(tag, invokedMessage)
        }
    }

    fun info(
        tag: String = formatTag(message::class.simpleName),
        message: () -> String
    ) {
        if (showLog(LogLevel.INFO)) {
            val invokedMessage = message.invoke()
            Logger.info(tag, invokedMessage)
            handleCallbacks(tag, invokedMessage)
        }
    }

    fun warn(
        tag: String = formatTag(message::class.simpleName),
        message: () -> String
    ) {
        if (showLog(LogLevel.WARN)) {
            val invokedMessage = message.invoke()
            Logger.warn(tag, invokedMessage)
            handleCallbacks(tag, invokedMessage)
        }
    }

    fun error(
        tag: String = formatTag(message::class.simpleName),
        throwable: Throwable? = null,
        message: () -> String
    ) {
        if (showLog(LogLevel.ERROR)) {
            val invokedMessage = message.invoke()
            Logger.error(tag, invokedMessage, throwable)
            handleCallbacks(tag, invokedMessage, throwable)
        }
    }

    private fun handleCallbacks(
        tag: String = message::class.simpleName ?: "",
        message: String,
        throwable: Throwable? = null
    ) {
        callbacks.forEach { callback ->
            callback.invoke(tag, message, throwable)
        }
    }

    private fun formatTag(tag: String?): String =
        tag?.let {
            it.split("$").firstOrNull() ?: ""
        } ?: ""

    private fun showLog(logLevel: LogLevel) = logLevel.ordinal >= this.logLevel.ordinal
}
