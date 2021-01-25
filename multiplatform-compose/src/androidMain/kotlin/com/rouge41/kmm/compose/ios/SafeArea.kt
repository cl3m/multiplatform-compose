package com.rouge41.kmm.compose.ios

import com.rouge41.kmm.compose.runtime.Composable

@Composable
actual fun SafeArea(content: @Composable () -> Unit) {
    content.invoke()
}
