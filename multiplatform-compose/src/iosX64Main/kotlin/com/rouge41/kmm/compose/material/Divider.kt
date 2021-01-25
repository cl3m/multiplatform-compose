package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.unit.Dp
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ios.getCurrentView
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import kotlinx.cinterop.useContents
import platform.UIKit.UIEdgeInsetsMake
import platform.UIKit.UITableViewCell
import platform.UIKit.layoutMargins
import platform.UIKit.superview

@Composable
actual fun Divider(
        modifier: Modifier,
        color: Color?,
        thickness: Dp,
        startIndent: Dp
) {
    val cell = getCurrentView().superview
    if (cell is UITableViewCell) {
        val left = cell.layoutMargins.useContents { left }
        cell.separatorInset = UIEdgeInsetsMake(0.0, left, 0.0, 0.0)
    }
}