package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.runtime.Composable

@Composable
expect fun Scaffold(
        topBar: @Composable () -> Unit,
        content: @Composable (PaddingValues) -> Unit
)