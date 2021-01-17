package com.rouge41.kmm.compose

actual class ImageVector

@Composable
actual fun Icon(
    imageVector: ImageVector,
    modifier: Modifier,
    tint: Color?
) {
}

actual fun iconArrowBack(): ImageVector {
    TODO("Not needed in iOS")
}