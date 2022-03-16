package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.runtime.Composable

@Composable
actual fun Scaffold(
        topBar: @Composable () -> Unit,
        content: @Composable (PaddingValues) -> Unit
) = androidx.compose.material.Scaffold(topBar = topBar, content = content)