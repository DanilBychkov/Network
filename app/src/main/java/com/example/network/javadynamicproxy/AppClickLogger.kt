package com.example.network.javadynamicproxy

interface AppClickLogger {

    @EventName("Click")
    fun click(@Param("place") place: String)
}