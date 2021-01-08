package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.Composable
import platform.UIKit.UIViewController
import com.rouge41.kmm.compose.HostingController as HC

class HostingController(
    controller: UIViewController,
    content: @Composable() () -> Unit
) : HC(controller, content)
