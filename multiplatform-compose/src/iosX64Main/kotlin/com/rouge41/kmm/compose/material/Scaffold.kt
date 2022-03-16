package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.unit.dp

@Composable
actual fun Scaffold(
        topBar: @Composable () -> Unit,
        content: @Composable (PaddingValues) -> Unit
) {
    content.invoke(PaddingValues(0.dp))
}