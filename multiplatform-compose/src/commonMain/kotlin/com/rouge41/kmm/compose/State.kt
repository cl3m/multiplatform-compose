package com.rouge41.kmm.compose

import kotlin.reflect.KProperty

@Composable expect fun <T> remember(calculation: @ComposableContract() () -> T): T

expect fun <T> mutableStateOf(value: T): MutableState<T>

expect operator fun <T> State<T>.getValue(thisObj: Any?, property: KProperty<*>): T
expect operator fun <T> MutableState<T>.setValue(thisObj: Any?, property: KProperty<*>, value: T)

expect interface MutableState<T> : State<T> {
    override var value: T
}

expect interface State<T> {
    val value: T
}
