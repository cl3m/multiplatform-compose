package com.rouge41.kmm.compose

import platform.Foundation.NSLog
import kotlin.reflect.KProperty

// simple cache implementation
val cache = HashMap<String, Any>()

@Composable actual fun <T> remember(calculation: @ComposableContract() () -> T): T {
    val controller = getCurrentController()
    val key = "$controller ${calculation::class}"
    return if (cache[key] != null) {
        cache[key] as T
    } else {
        val value = calculation()
        cache[key] = value as Any
        value
    }
}

actual fun <T> mutableStateOf(value: T): MutableState<T> {
    return iosMutableState(value = value)
}

actual operator fun <T> State<T>.getValue(thisObj: Any?, property: KProperty<*>): T = value
actual operator fun <T> MutableState<T>.setValue(thisObj: Any?, property: KProperty<*>, value: T) {
    this.value = value
    refreshContent()
}

actual interface MutableState<T> : State<T> {
    actual override var value: T
}

actual interface State<T> {
    actual val value: T
}

class iosMutableState<T>(value: T) : MutableState<T> {
    private var _value: T = value
    override var value: T
        get() = _value
        set(value) {
            _value = value
            refreshContent()
        }
}

class iosState<T>(override val value: T) : State<T>
