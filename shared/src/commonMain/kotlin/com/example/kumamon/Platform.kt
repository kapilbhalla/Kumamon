package com.example.kumamon

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform