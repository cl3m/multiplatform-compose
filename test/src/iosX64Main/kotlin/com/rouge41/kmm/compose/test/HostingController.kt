package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ios.SafeArea
import com.rouge41.kmm.compose.material.Text
import platform.UIKit.UIImageView
import platform.UIKit.UIViewController
import com.rouge41.kmm.compose.ios.HostingController as HC

class HostingController(
    controller: UIViewController,
    content: @Composable() () -> Unit,
    imageViewLoader: (UIImageView, String) -> Unit
) : HC(controller, content, imageViewLoader)

@Composable
actual fun Test() {
    SafeArea { Text("iOS") }
}