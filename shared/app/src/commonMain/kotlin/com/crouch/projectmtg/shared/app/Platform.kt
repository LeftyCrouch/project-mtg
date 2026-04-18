package com.crouch.projectmtg.shared.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform