package com.rouge41.kmm.compose

import kotlinx.cinterop.useContents
import platform.Foundation.NSLog
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