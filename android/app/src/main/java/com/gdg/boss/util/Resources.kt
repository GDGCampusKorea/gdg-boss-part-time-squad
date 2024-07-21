package com.gdg.boss.util

sealed class Resources<out T> {
    class Success<T>(val data: T) : Resources<T>()
    class Failed(val throwable: Throwable) : Resources<Nothing>()
}