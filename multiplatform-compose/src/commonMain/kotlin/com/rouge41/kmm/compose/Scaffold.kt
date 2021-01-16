package com.rouge41.kmm.compose

@Composable
expect fun Scaffold(
    topBar: @Composable () -> Unit,
    bodyContent: @Composable (PaddingValues) -> Unit
)

@Composable
expect fun TopAppBar(title: @Composable () -> Unit)
