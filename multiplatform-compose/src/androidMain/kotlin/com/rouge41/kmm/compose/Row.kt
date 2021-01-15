package com.rouge41.kmm.compose

import androidx.compose.foundation.layout.Row as _Row

actual typealias RowScope = androidx.compose.foundation.layout.RowScope

@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
@Composable
actual fun Row(
    modifier: Modifier = Modifier,
    horizontalArrangement: ArrangementHorizontal = Arrangement.Start,
    verticalAlignment: AlignmentVertical = Alignment.Top,
    content: @Composable RowScope.() -> Unit
) {
    _Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment,
        content = content
    )
}