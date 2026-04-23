package com.crouch.projectmtg.shared.core.logger

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TestLogIt {

    @BeforeTest
    fun beforeTests() {
        LogIt.logLevel = LogLevel.INFO
        LogIt.removeCallbacks()
    }

    @Test
    fun `log verbose message`() {
        var messagesInvoked = 0
        LogIt.logLevel = LogLevel.VERBOSE
        LogIt.verbose { "${++messagesInvoked}" }
        assertEquals(
            expected = 1,
            actual = messagesInvoked
        )
    }

    @Test
    fun `do not log verbose message`() {
        var messagesInvoked = 0
        LogIt.verbose { "${++messagesInvoked}" }
        assertEquals(
            expected = 0,
            actual = messagesInvoked
        )
    }

    @Test
    fun `log debug message`() {
        var messagesInvoked = 0
        LogIt.logLevel = LogLevel.DEBUG
        LogIt.debug { "${++messagesInvoked}" }
        assertEquals(
            expected = 1,
            actual = messagesInvoked
        )
    }

    @Test
    fun `do not log debug message`() {
        var messagesInvoked = 0
        LogIt.debug { "${++messagesInvoked}" }
        assertEquals(
            expected = 0,
            actual = messagesInvoked
        )
    }

    @Test
    fun `log info message`() {
        var messagesInvoked = 0
        LogIt.info { "${++messagesInvoked}" }
        assertEquals(
            expected = 1,
            actual = messagesInvoked
        )
    }

    @Test
    fun `do not log info message`() {
        var messagesInvoked = 0
        LogIt.logLevel = LogLevel.WARN
        LogIt.info { "${++messagesInvoked}" }
        assertEquals(
            expected = 0,
            actual = messagesInvoked
        )
    }

    @Test
    fun `log warn message`() {
        var messagesInvoked = 0
        LogIt.warn { "${++messagesInvoked}" }
        assertEquals(
            expected = 1,
            actual = messagesInvoked
        )
    }

    @Test
    fun `do not log warn message`() {
        var messagesInvoked = 0
        LogIt.logLevel = LogLevel.ERROR
        LogIt.warn { "${++messagesInvoked}" }
        assertEquals(
            expected = 0,
            actual = messagesInvoked
        )
    }

    @Test
    fun `log error message`() {
        var messagesInvoked = 0
        LogIt.error { "${++messagesInvoked}" }
        assertEquals(
            expected = 1,
            actual = messagesInvoked
        )
    }

    @Test
    fun `log error message with throwable`() {
        var messagesInvoked = 0
        LogIt.logLevel = LogLevel.ERROR
        LogIt.error(
            throwable = Throwable("error")
        ) {
            "${++messagesInvoked}"
        }
        assertEquals(
            expected = 1,
            actual = messagesInvoked
        )
    }

    @Test
    fun `add callback and it should invoke`() {
        var messagesInvoked = 0
        LogIt.addCallback { tag, message, throwable ->
            println("$tag: increment message again from $message to ${++messagesInvoked} ${throwable ?: ""}")
        }
        LogIt.info { "${++messagesInvoked}" }
        assertEquals(
            expected = 2,
            actual = messagesInvoked
        )
    }

    @Test
    fun `remove callbacks`() {
        var messagesInvoked = 0
        LogIt.addCallback { tag, message, throwable ->
            println("$tag: increment message again from $message to ${++messagesInvoked} ${throwable ?: ""}")
        }
        LogIt.removeCallbacks()
        LogIt.info { "${++messagesInvoked}" }
        assertEquals(
            expected = 1,
            actual = messagesInvoked
        )
    }

    @Test
    fun `confirm tag`() {
        val expectedTag = "TestLogIt"
        LogIt.addCallback { tag, message, throwable ->
            assertEquals(
                expected = expectedTag,
                actual = tag
            )
            println("$tag: $message ${throwable ?: ""}")
        }
        LogIt.info { "Hello World" }
    }
}
