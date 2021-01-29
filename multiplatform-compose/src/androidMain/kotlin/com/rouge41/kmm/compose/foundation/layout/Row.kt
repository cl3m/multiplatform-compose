package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentVertical
import com.rouge41.kmm.compose.ui.Modifier
import androidx.compose.foundation.layout.Row as _Row

@Suppress("NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS")
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