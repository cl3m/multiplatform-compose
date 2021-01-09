package com.rouge41.kmm.compose

import androidx.compose.material.ListItem as _ListItem

@Composable
actual fun ListItem(modifier: Modifier, text: @Composable () -> Unit) = _ListItem(modifier = modifier, text = text)