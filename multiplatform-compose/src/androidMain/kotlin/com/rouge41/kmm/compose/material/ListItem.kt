package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.runtime.Composable
import androidx.compose.material.ListItem as _ListItem

@Composable
actual fun ListItem(modifier: Modifier, text: @Composable () -> Unit) = _ListItem(modifier = modifier, text = text)