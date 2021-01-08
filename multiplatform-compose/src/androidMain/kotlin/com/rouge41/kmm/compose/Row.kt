package com.rouge41.kmm.compose

import androidx.compose.foundation.layout.Row as _Row

actual typealias RowScope = androidx.compose.foundation.layout.RowScope

@Composable
actual fun Row(
    modifier: Modifier,
    horizontalArrangement: ArrangementHorizontal,
    verticalAlignment: AlignmentVertical,
    content: @Composable RowScope.() -> Unit
) {
    _Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment,
        content = content
    )
}

@Composable
actual fun Row(content: @Composable RowScope.() -> Unit) {
    _Row(content = content)
}
