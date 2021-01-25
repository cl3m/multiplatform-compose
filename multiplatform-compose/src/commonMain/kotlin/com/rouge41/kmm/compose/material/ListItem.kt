package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.runtime.Composable

@Composable
expect fun ListItem(modifier: Modifier, text: @Composable () -> Unit)