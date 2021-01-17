package com.rouge41.kmm.compose

import platform.UIKit.UIEdgeInsetsMake
import platform.UIKit.UITableViewCell
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
        cell.separatorInset = UIEdgeInsetsMake(0.0, 15.0, 0.0, 0.0)
    }
}