package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGPointMake
import platform.CoreGraphics.CGPointZero
import platform.Foundation.NSLog
import platform.UIKit.*
import platform.darwin.*

actual typealias NavHostController = UIComposeNavigationController
actual typealias NavGraphBuilder = UIComposeNavigationController
actual class NavDeepLink
actual class NamedNavArgument
actual typealias NavController = UIComposeNavigationController
actual class NavOptionsBuilder

actual fun rememberNavController(): NavHostController = remember { UIComposeNavigationController() }

@Composable
actual fun NavHost(
    navController: NavHostController,
    startDestination: String,
    route: String?,
    builder: NavGraphBuilder.() -> Unit) {
    if (navController.routes.isEmpty()) {
        navController.routes.add(startDestination)
    }
    getCurrentController().addChildViewController(navController)
    getCurrentView().addSubview(navController.view)
    navController.view.configureLayoutWithBlock { layout ->
        layout?.isEnabled = true
        layout?.width = YGPercentValue(100.0)
        layout?.height = YGPercentValue(100.0)
    }
    navController.didMoveToParentViewController(getCurrentController())
    addController(navController) { builder.invoke(navController) }
}

class UIComposeNavigationController() : UINavigationController(nibName = null, bundle = null) {
    var routes = mutableListOf<String>()
    var composableControllers = mutableListOf<UIComposeViewController>()

    fun navigate(route: String) {
        routes.add(route)
        val controller = composableControllers.first { it.route.split("/").first() == route.split("/").first() }
        val last = controller.route.split("/").last()
        //TODO: Use regex and support multiple params
        if (last.contains("{")) {
            val key = last.substring(1, last.length-1)
            val value = route.split("/").last()
            controller.bundle.set(key, value)
            controller.initialTitle?.let { controller.title = it.replace("{$key}", value) }

        }
        layout(controller)
        resetTableViews(controller.view)
        resetScrollViews(controller.view)
        pushViewController(controller, true)
        dispatch_async(dispatch_get_main_queue()) {
            //TODO: Avoid a full relayout
            layout(controller)
        }
    }

    fun popBackStack(): Boolean {
        if(viewControllers.size > 1) {
            popViewControllerAnimated(true)
            return true
        } else {
            return false
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

    private fun resetTableViews(view: UIView) {
        for (view in view.subviews) {
            if (view is UITableView) {
                view.beginUpdates()
                val y = view.adjustedContentInset.useContents { top }
                view.setContentOffset(CGPointMake(0.0, -y), false)
                view.endUpdates()
            } else if (view is UIView){
                resetTableViews(view)
            }
        }
    }

    private fun resetScrollViews(view: UIView) {
        for (view in view.subviews) {
            if (view !is UITableView && view is UIScrollView) {
                val y = view.adjustedContentInset.useContents { top }
                view.setContentOffset(CGPointMake(0.0, -y), false)
            } else if (view is UIView){
                resetScrollViews(view)
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

actual fun NavGraphBuilder.composable(
    route: String,
    title: String?,
    arguments: List<NamedNavArgument>,
    deepLinks: List<NavDeepLink>,
    content: @Composable (NavBackStackEntry) -> Unit) {
    val navigationController = getCurrentController() as UIComposeNavigationController
    var controller: UIComposeViewController? =
        navigationController.composableControllers.firstOrNull { it.route == route }
    if (controller == null) {
        controller = UIComposeViewController(route, initialTitle = title)
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
        addController(controller) { content.invoke(NavBackStackEntry(controller.bundle)) }
        if (!navigationController.viewControllers.contains(controller)) {
            navigationController.pushViewController(controller, false)
        }
    } else {
        for (view in controller.view.subviews) {
            (view as UIView).removeFromSuperview()
        }
    }
}

class UIComposeViewController(val route: String, val initialTitle: String?) : UIViewController(nibName = null, bundle = null) {
    lateinit var content: @Composable (NavBackStackEntry) -> Unit
    val bundle = Bundle()
}

actual fun NavController.navigate(
    route: String,
    builder: NavOptionsBuilder.() -> Unit
) {
    navigate(route)
}

actual class Bundle {
    val _map = emptyMap<String, Any>().toMutableMap()
    fun <T> set(key: String, value: T) {
        _map[key] = value as Any
    }
    actual fun get(p0: String): Any? {
        return _map[p0]
    }
}

actual data class NavBackStackEntry(val bundle: Bundle? = null) {
    actual val arguments: Bundle?
        get() = bundle
}