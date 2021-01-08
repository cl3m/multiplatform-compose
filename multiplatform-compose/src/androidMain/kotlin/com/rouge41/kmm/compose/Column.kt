package com.rouge41.kmm.compose

import androidx.compose.foundation.layout.Column as _Column

actual typealias ColumnScope = androidx.compose.foundation.layout.ColumnScope

@Composable
actual fun Column(
    modifier: Modifier,
    verticalArrangement: ArrangementVertical,
    horizontalAlignment: AlignmentHorizontal,
    content: @Composable ColumnScope.() -> Unit
) {
    _Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}

@Composable
actual fun Column(content: @Composable ColumnScope.() -> Unit) {
    _Column(content = content)
}
