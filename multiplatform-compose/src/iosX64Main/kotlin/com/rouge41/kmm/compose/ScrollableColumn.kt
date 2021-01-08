package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import platform.UIKit.*

@Composable
actual fun ScrollableColumn(content: @Composable ColumnScope.() -> Unit) {
    val scrollView = UIComposeScrollView.createOrReuse("${content::class}")
    scrollView.configureLayoutWithBlock { layout ->
        layout?.isEnabled = true
        layout?.width = YGPercentValue(100.0)
        layout?.height = YGPercentValue(100.0)
        layout?.overflow = YGOverflow.YGOverflowScroll
    }
    addSubview(scrollView) { content.invoke(iosColumnScope()) }
}
