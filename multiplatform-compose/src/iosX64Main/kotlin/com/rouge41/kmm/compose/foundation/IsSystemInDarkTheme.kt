package com.rouge41.kmm.compose.foundation

import com.rouge41.kmm.compose.ios.HostingController
import com.rouge41.kmm.compose.runtime.Composable
import platform.UIKit.UIUserInterfaceStyle

@Composable
actual fun isSystemInDarkTheme(): Boolean {
    return HostingController.host.controller.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.UIUserInterfaceStyleDark
}