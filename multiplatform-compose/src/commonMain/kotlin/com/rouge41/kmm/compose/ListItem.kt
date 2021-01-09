package com.rouge41.kmm.compose

@Composable
expect fun ListItem(modifier: Modifier, text: @Composable () -> Unit)