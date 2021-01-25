package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.unit.dp
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color

@Composable
expect fun Divider(
        modifier: Modifier = Modifier,
        color: Color? = null,
        thickness: Dp = 1.dp,
        startIndent: Dp = 0.dp
)