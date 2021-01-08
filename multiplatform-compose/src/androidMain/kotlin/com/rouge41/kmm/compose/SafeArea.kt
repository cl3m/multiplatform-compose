package com.rouge41.kmm.compose

@Composable
actual fun SafeArea(content: @Composable () -> Unit) {
    content.invoke()
}
