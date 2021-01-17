package com.rouge41.kmm.compose

expect class ImageVector

@Composable
expect fun Icon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color? = null
)

expect fun iconArrowBack(): ImageVector