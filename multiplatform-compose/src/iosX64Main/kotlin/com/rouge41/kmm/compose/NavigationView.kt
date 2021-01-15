package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.cValue
import platform.CoreGraphics.CGRectZero
import platform.Foundation.NSLog
import platform.UIKit.*
import platform.darwin.*

fun rememberNavController() = remember { UIComposeNavigationController() }
@Composable
fun NavigationView(navigationController: UIComposeNavigationController = rememberNavController(), startDestination: String, content: @Composable (UIComposeNavigationController) -> Unit) {
    if (navigationController.routes.isEmpty()) {
        navigationController.routes.add(startDestination)
    }
    getCurrentController().addChildViewController(navigationController)
    getCurrentView().addSubview(navigationController.view)
    navigationController.view.configureLayoutWithBlock { layout ->
        layout?.isEnabled = true
        layout?.width = YGPercentValue(100.0)
        layout?.height = YGPercentValue(100.0)
    }
    navigationController.didMoveToParentViewController(getCurrentController())
    addController(navigationController) { content.invoke(navigationController) }
}

class UIComposeNavigationController() : UINavigationController(nibName = null, bundle = null) {
    var routes = mutableListOf<String>()
    var composableControllers = mutableListOf<UIComposeViewController>()

    fun navigate(destination : String) {
        routes.add(destination)
        val controller = composableControllers.first { it.route == destination }
        layout(controller)
        pushViewController(controller, true)
        dispatch_async(dispatch_get_main_queue()) {
            layout(controller)
        }
    }

    private fun layout(controller: UIComposeViewController) {
        controller.view.setFrame(view.bounds)
        addController(this.tabBarController) {
            addController(this) {
                addControllerAndLayout(controller)
            }
        }
    }

    override fun popViewControllerAnimated(animated: Boolean): UIViewController? {
        val controller = viewControllers!!.last()
        if (controller is UIComposeViewController) {
            routes.remove(controller.route)
        }
        return super.popViewControllerAnimated(animated)
    }
}

fun composable(route: String,
               title: String,
               content: @Composable () -> Unit) {
    val navigationController = getCurrentController() as UIComposeNavigationController
    var controller: UIComposeViewController? =
        navigationController.composableControllers.firstOrNull { it.route == route }
    if (controller == null) {
        controller = UIComposeViewController(route)
        navigationController.composableControllers.add(controller)
    }
    controller.title = title
    controller.view.backgroundColor = systemBackgroundColor()
    controller.view.configureLayoutWithBlock { layout ->
        layout?.isEnabled = true
        layout?.width = YGPercentValue(100.0)
        layout?.height = YGPercentValue(100.0)
        layout?.flexDirection = YGFlexDirection.YGFlexDirectionColumn
        layout?.justifyContent = YGJustify.YGJustifyFlexStart
        layout?.alignItems = YGAlign.YGAlignFlexStart
    }
    controller.content = content
    if (navigationController.routes.contains(route)) {
        addController(controller) { content.invoke() }
        if (!navigationController.viewControllers.contains(controller)) {
            navigationController.pushViewController(controller, false)
        }
    } else {
        for (view in controller.view.subviews) {
            (view as UIView).removeFromSuperview()
        }
    }
}

class UIComposeViewController(val route: String) : UIViewController(nibName = null, bundle = null) {
    lateinit var content: (@Composable () -> Unit)
}
