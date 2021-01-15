package com.rouge41.kmm.compose

import androidx.compose.foundation.layout.Column as _Column

actual typealias ColumnScope = androidx.compose.foundation.layout.ColumnScope

@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
@Composable
actual fun Column(
    modifier: Modifier = Modifier,
    verticalArrangement: ArrangementVertical = Arrangement.Top,
    horizontalAlignment: AlignmentHorizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit
) {
    _Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}