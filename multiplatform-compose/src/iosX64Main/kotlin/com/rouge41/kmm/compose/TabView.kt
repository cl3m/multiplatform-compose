package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import platform.UIKit.*
import platform.darwin.NSUInteger
import kotlinx.cinterop.convert
import platform.Foundation.NSLog

fun rememberTabBarController() = remember { UITabBarController() }

@Composable
fun TabView(tabBarController: UITabBarController = rememberTabBarController(), content: @Composable () -> Unit) {
    getCurrentController().addChildViewController(tabBarController)
    getCurrentView().addSubview(tabBarController.view)
    tabBarController.view.configureLayoutWithBlock { layout ->
        layout?.isEnabled = true
        layout?.width = YGPercentValue(100.0)
        layout?.height = YGPercentValue(100.0)
    }
    tabBarController.didMoveToParentViewController(getCurrentController())
    addController(tabBarController) { content.invoke() }
    tabBarController.viewControllers = tabBarController.viewControllers?.filter { (it as? UIViewController)?.view?.subviews?.isNotEmpty() ?: false }
}

@Composable
fun Tab(title: String, image: UIImage?, content: @Composable () -> Unit) {
    val tabBarController = getCurrentController() as UITabBarController
    var controller: UIViewController? = tabBarController.viewControllers?.filter { (it as? UIViewController)?.tabBarItem?.title == title }?.firstOrNull() as? UIViewController
    if (controller == null) {
        controller = UIViewController()
        tabBarController.viewControllers = (tabBarController.viewControllers ?: listOf<UIViewController>()) + controller
    }
    controller.title = title
    controller.tabBarItem.title = title
    controller.tabBarItem.image = image
    controller.view.configureLayoutWithBlock { layout ->
        layout?.isEnabled = true
        layout?.width = YGPercentValue(100.0)
        layout?.height = YGPercentValue(100.0)
        layout?.flexDirection = YGFlexDirection.YGFlexDirectionColumn
        layout?.justifyContent = YGJustify.YGJustifyFlexStart
        layout?.alignItems = YGAlign.YGAlignFlexStart
    }
    addController(controller) { content.invoke() }
}