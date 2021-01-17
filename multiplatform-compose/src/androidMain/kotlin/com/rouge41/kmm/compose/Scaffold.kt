package com.rouge41.kmm.compose

import androidx.compose.material.Scaffold as _Scaffold
import androidx.compose.material.TopAppBar as _TopAppBar

@Composable
actual fun Scaffold(
    topBar: @Composable () -> Unit,
    bodyContent: @Composable (PaddingValues) -> Unit
) = _Scaffold(topBar = topBar, bodyContent = bodyContent)

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun TopAppBar(title: @Composable () -> Unit, navigationIcon: @Composable (() -> Unit)? = null) = _TopAppBar(title = title, navigationIcon = navigationIcon)
