package com.rouge41.kmm.compose.ios

import com.rouge41.kmm.compose.runtime.Composable

@Composable
expect fun SafeArea(content: @Composable () -> Unit)
