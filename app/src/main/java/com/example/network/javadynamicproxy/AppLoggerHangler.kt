package com.example.network.javadynamicproxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class AppLoggerHandler(private val clickTracker: ClickTracker) : InvocationHandler {
    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any {
        val eventName = method.annotations.firstNotNullOf { it as? EventName }
        val clickName = eventName.value
        clickTracker.trackClick(clickName)
        return Unit
    }
}

interface ClickTracker {

    fun trackClick(place: String)
}