package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.runtime.Composable

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun TopAppBar(title: @Composable () -> Unit, navigationIcon: @Composable (() -> Unit)? = null) = androidx.compose.material.TopAppBar(title = title, navigationIcon = navigationIcon)