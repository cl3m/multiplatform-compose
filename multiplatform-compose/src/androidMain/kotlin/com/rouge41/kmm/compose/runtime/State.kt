package com.rouge41.kmm.compose.runtime

import androidx.compose.runtime.State
import kotlin.reflect.KProperty
import androidx.compose.runtime.mutableStateOf as _mutableStateOf
import androidx.compose.runtime.remember as _remember

@Composable
actual fun <T> remember(calculation: @ComposableContract() () -> T): T {
    return _remember(calculation)
}

actual fun <T> mutableStateOf(value: T): MutableState<T> {
    return _mutableStateOf(value)
}

actual operator fun <T> State<T>.getValue(thisObj: Any?, property: KProperty<*>): T = value
actual operator fun <T> MutableState<T>.setValue(thisObj: Any?, property: KProperty<*>, value: T) {
    this.value = value
}

actual typealias MutableState<T> = androidx.compose.runtime.MutableState<T>

actual typealias State<T> = androidx.compose.runtime.State<T>
