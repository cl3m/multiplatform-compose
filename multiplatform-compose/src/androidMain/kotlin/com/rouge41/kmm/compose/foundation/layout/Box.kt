package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Alignment
import com.rouge41.kmm.compose.ui.AlignmentVerticalAndHorizontal
import com.rouge41.kmm.compose.ui.Modifier
import androidx.compose.foundation.layout.Box as _Box

actual typealias BoxScope = androidx.compose.foundation.layout.BoxScope

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun Box(
    modifier: Modifier = Modifier,
    contentAlignment: AlignmentVerticalAndHorizontal = Alignment.TopStart,
    content: @Composable BoxScope.() -> Unit
) = _Box(modifier = modifier, contentAlignment = contentAlignment, content = content)