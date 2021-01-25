package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.runtime.Composable

@Composable
expect fun TopAppBar(title: @Composable () -> Unit, navigationIcon: @Composable (() -> Unit)? = null)