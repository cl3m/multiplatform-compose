package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.useContents
import platform.CoreGraphics.*
import platform.Foundation.NSLog
import platform.Foundation.NSSelectorFromString
import platform.UIKit.*
import platform.posix.printf

@Composable
actual fun SafeArea(content: @Composable () -> Unit) {
    val view = UIComposeView.createOrReuse("${content::class}")
    val statusBarHeight = UIApplication.sharedApplication.statusBarFrame.useContents { size.height }
    val window = UIApplication.sharedApplication.keyWindow!!
    var paddingTop: CGFloat
    val paddingLeft: CGFloat
    var paddingBottom: CGFloat
    val paddingRight: CGFloat
    if (window.respondsToSelector(NSSelectorFromString("safeAreaInsets"))) {
        paddingTop = window.safeAreaInsets.useContents { top }
        paddingLeft = window.safeAreaInsets.useContents { left }
        paddingBottom = window.safeAreaInsets.useContents { bottom }
        paddingRight = window.safeAreaInsets.useContents { right }
    } else {
        paddingTop = statusBarHeight
        paddingLeft = 0.0
        paddingBottom = 0.0
        paddingRight = 0.0
    }
    if (HostingController.controllers.lastOrNull { it is UIComposeNavigationController } != null) {
        val navigationController = HostingController.controllers.last { it is UIComposeNavigationController } as UIComposeNavigationController
        var navigationBarHeight = navigationController.navigationBar.frame.useContents { size.height }
        paddingTop += navigationBarHeight
    }
    if (HostingController.controllers.lastOrNull { it is UITabBarController } != null) {
        val tabBarController = HostingController.controllers.last { it is UITabBarController } as UITabBarController
        var tabBarHeight = tabBarController.tabBar.frame.useContents { size.height }
		paddingBottom = tabBarHeight
    }
    view.configureLayoutWithBlock { layout ->
        layout?.isEnabled = true
        layout?.width = YGPercentValue(100.0)
        layout?.height = YGPercentValue(100.0)
        layout?.paddingTop = YGPointValue(paddingTop)
        layout?.paddingLeft = YGPointValue(paddingLeft)
        layout?.paddingBottom = YGPointValue(paddingBottom)
        layout?.paddingRight = YGPointValue(paddingRight)
        layout?.flexDirection = YGFlexDirection.YGFlexDirectionColumn
        layout?.justifyContent = YGJustify.YGJustifyFlexStart
        layout?.alignItems = YGAlign.YGAlignFlexStart
    }
    addSubview(view) { content.invoke() }
}
