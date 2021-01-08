package com.rouge41.kmm.compose

import androidx.compose.foundation.ScrollableColumn as _ScrollableColumn

@Composable
actual fun ScrollableColumn(content: @Composable ColumnScope.() -> Unit) {
    _ScrollableColumn(content = content)
}
