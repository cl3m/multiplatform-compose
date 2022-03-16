package com.rouge41.kmm.compose.runtime

import kotlin.reflect.KProperty

@Composable
expect fun <T> remember(calculation: () -> T): T

expect fun <T> mutableStateOf(value: T): MutableState<T>

expect operator fun <T> MutableState<T>.getValue(thisObj: Any?, property: KProperty<*>): T
expect operator fun <T> MutableState<T>.setValue(thisObj: Any?, property: KProperty<*>, value: T)

expect interface MutableState<T> {
    var value: T
}
