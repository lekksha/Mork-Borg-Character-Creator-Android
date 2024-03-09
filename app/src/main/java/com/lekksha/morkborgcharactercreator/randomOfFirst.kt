package com.lekksha.morkborgcharactercreator

fun <T> List<T>.randomOfFirst(x: Int): T? {
    return if (this.size >= x) {
        this.subList(0, x).random()
    } else {
        null
    }
}