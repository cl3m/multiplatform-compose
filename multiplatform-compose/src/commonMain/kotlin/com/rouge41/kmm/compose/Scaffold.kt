package com.rouge41.kmm.compose

expect class PaddingValues

@Composable
expect fun Scaffold(
    topBar: @Composable () -> Unit,
    bodyContent: @Composable (PaddingValues) -> Unit
)

@Composable
expect fun TopAppBar(title: @Composable () -> Unit)
