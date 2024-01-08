package com.example.network.javadynamicproxy

import java.lang.reflect.Proxy
import kotlin.properties.Delegates

class LoggerProxy private constructor(
    private val clickTracker: ClickTracker
) {

    fun <T : Any> create(clazz: Class<T>): T {
        return Proxy.newProxyInstance(
            clazz.classLoader,
            arrayOf(clazz),
            AppLoggerHandler(clickTracker)
        ) as T
    }

    class Builder {

        private var clickTracker: ClickTracker by Delegates.notNull()

        fun clickTracker(clickTracker: ClickTracker): Builder {
            this.clickTracker = clickTracker
            return this
        }

        fun build(): LoggerProxy {
            return LoggerProxy(clickTracker)
        }
    }
}