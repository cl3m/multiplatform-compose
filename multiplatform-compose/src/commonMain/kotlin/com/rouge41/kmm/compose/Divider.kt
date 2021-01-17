package com.rouge41.kmm.compose

@Composable
expect fun Divider(
    modifier: Modifier = Modifier,
    color: Color? = null,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp
)