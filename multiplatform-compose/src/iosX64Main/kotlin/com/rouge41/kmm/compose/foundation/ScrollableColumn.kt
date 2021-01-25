package com.rouge41.kmm.compose.foundation

import cocoapods.YogaKit.*
import com.rouge41.kmm.compose.foundation.layout.ArrangementVertical
import com.rouge41.kmm.compose.foundation.layout.ColumnScope
import com.rouge41.kmm.compose.foundation.layout.PaddingValues
import com.rouge41.kmm.compose.foundation.layout.iosColumnScope
import com.rouge41.kmm.compose.ios.UIComposeScrollView
import com.rouge41.kmm.compose.ios.addSubview
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.AlignmentHorizontal
import com.rouge41.kmm.compose.ui.Modifier

actual class ScrollState

@Composable
actual fun ScrollableColumn(
        modifier: Modifier,
        scrollState: ScrollState,
        verticalArrangement: ArrangementVertical,
        horizontalAlignment: AlignmentHorizontal,
        reverseScrollDirection: Boolean,
        isScrollEnabled: Boolean,
        contentPadding: PaddingValues,
        content: @Composable ColumnScope.() -> Unit
) {
    val scrollView = UIComposeScrollView.createOrReuse("${content::class}")
    scrollView.configureLayoutWithBlock { layout ->
        layout?.isEnabled = true
        layout?.width = YGPercentValue(100.0)
        layout?.height = YGPercentValue(100.0)
        layout?.overflow = YGOverflow.YGOverflowScroll
    }
    modifier.setup(scrollView)
    addSubview(scrollView) { content.invoke(iosColumnScope()) }
}

@Composable
actual fun rememberScrollState(
    initial: Float,
    interactionState: InteractionState?
): ScrollState = com.rouge41.kmm.compose.foundation.ScrollState()