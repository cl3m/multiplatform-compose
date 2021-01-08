package com.rouge41.kmm.compose

import platform.UIKit.*

@Composable
actual fun Spacer(modifier: Modifier) {
    val view = UIView()
    modifier.setup(view)
    addSubview(view)
}
