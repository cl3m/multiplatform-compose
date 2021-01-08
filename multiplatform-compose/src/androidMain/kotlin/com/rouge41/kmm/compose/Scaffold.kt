package com.rouge41.kmm.compose

import androidx.compose.material.Scaffold as _Scaffold
import androidx.compose.material.TopAppBar as _TopAppBar

actual typealias PaddingValues = androidx.compose.foundation.layout.PaddingValues

@Composable
actual fun Scaffold(
    topBar: @Composable () -> Unit,
    bodyContent: @Composable (PaddingValues) -> Unit
) = _Scaffold(topBar = topBar, bodyContent = bodyContent)

@Composable
actual fun TopAppBar(title: @Composable () -> Unit) = _TopAppBar(title = title)
