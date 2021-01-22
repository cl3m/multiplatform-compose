package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import platform.UIKit.*

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
): ScrollState = ScrollState()