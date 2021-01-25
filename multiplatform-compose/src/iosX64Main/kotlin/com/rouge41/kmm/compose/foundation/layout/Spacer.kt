package com.rouge41.kmm.compose.foundation.layout

import com.rouge41.kmm.compose.ios.addSubview
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.Modifier
import platform.UIKit.*

@Composable
actual fun Spacer(modifier: Modifier) {
    val view = UIView()
    modifier.setup(view)
    addSubview(view)
}
