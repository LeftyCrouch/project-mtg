package com.crouch.projectmtg.shared.app

import com.crouch.projectmtg.shared.core.model.Card

class Greeting {
    private val platform = getPlatform()
    private val card = Card("Magic")

    fun greet(): String {
        return "Hello, ${platform.name}!, Get ready for some ${card.name}"
    }
}