package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.cValue
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGRectZero
import platform.CoreGraphics.CGSizeMake
import platform.Foundation.NSLog
import platform.UIKit.*
import platform.posix.printf
import kotlin.math.max

open class HostingController(val controller: UIViewController, val content: @Composable () -> Unit) {
    @ThreadLocal
    companion object {
        lateinit var host: HostingController
        var views = mutableListOf<UIView>()
        var controllers = mutableListOf<UIViewController>()
    }

    var isDirty = false

    fun viewDidLoad() {
        host = this
        val hostingView = HostingView()
        hostingView.setFrame(controller.view.frame)
        controller.view = hostingView
        views.add(hostingView)
        controllers.add(controller)
        refreshContent()
    }

    fun viewWillLayoutSubviews() {
        if (isDirty) {
            val hostingView = views.first()
            if (hostingView is HostingView) {
                removeSubViews(controller = controllers.first())
                hostingView.setContent(content)
                removeDirtySubViews(controller = controllers.first())
                isDirty = false
            }
        }
    }

    fun viewDidLayoutSubviews() {
        yoga_applyLayout(controller = controllers.first())
    }

    fun refreshContent() {
        isDirty = true
        controller.view.setNeedsLayout()
    }

    fun removeSubViews(controller: UIViewController) {
        if (controller !is UITabBarController && controller !is UIComposeNavigationController) {
            removeSubViews(controller.view)
        }
        for (child in controller.childViewControllers) {
            if (child is UIViewController) {
                removeSubViews(controller = child)
            }
        }
    }

    private fun removeSubViews(view: UIView) {
        for (subview in view.subviews) {
            if (subview is UIComposeView) {
                subview.isDirty = true
                removeSubViews(subview)
            } else if (subview is UIComposeScrollView) {
                subview.isDirty =
                    true
                removeSubViews(subview)
            } else {
                (subview as UIView).removeFromSuperview()
            }
        }
    }

    fun removeDirtySubViews(controller: UIViewController) {
        if (controller !is UITabBarController && controller !is UIComposeNavigationController) {
            removeDirtySubViews(controller.view)
        }
        for (child in controller.childViewControllers) {
            if (child is UIViewController) {
                removeDirtySubViews(controller = child)
            }
        }
    }

    private fun removeDirtySubViews(view: UIView) {
        for (subview in view.subviews) {
            if (subview is UIComposeView && subview.isDirty) {
                subview.removeFromSuperview()
            } else if (subview is UIComposeScrollView && subview.isDirty) {
                subview.removeFromSuperview()
            } else {
                removeDirtySubViews((subview as UIView))
            }
        }
    }

    fun yoga_applyLayout(controller: UIViewController) {
        yoga_applyLayout(controller.view)
        for (child in controller.childViewControllers) {
            if (child is UIViewController) {
                if (controller is UINavigationController) {
                    child.view.setFrame(controller.view.bounds)
                }
                if (controller is UITabBarController) {
                    child.view.setFrame(controller.view.bounds)
                }
                yoga_applyLayout(controller = child)
            }
        }
    }

    private fun yoga_applyLayout(view: UIView) {
        this.yoga_scrollViewFixPreLayout(view)
        view.yoga.applyLayoutPreservingOrigin(true)
        this.yoga_scrollViewFixPostLayout(view)
    }

    private fun yoga_scrollViewFixPreLayout(view: UIView) {
        if (view.isYogaEnabled && view is UIScrollView) {
            view.showsVerticalScrollIndicator = false
            view.showsHorizontalScrollIndicator = false
        }
        for (subview in view.subviews) {
            if (subview is UIView && subview.isYogaEnabled) {
                this.yoga_scrollViewFixPreLayout(subview)
            }
        }
    }

    private fun yoga_scrollViewFixPostLayout(view: UIView) {
        if (view.isYogaEnabled && view is UIScrollView) {
            view.showsVerticalScrollIndicator = true
            view.showsHorizontalScrollIndicator = true
            var w = 0.0
            var h = 0.0
            for (subview in view.subviews) {
                if (subview is UIView) {
                    val fw = subview.frame.useContents { origin.x + size.width }
                    val fh = subview.frame.useContents { origin.y + size.height }
                    w = max(fw, w)
                    h = max(fh, h)
                }
            }
            view.setContentSize(CGSizeMake(w, h))
        }
        for (subview in view.subviews) {
            if (subview is UIView && subview.isYogaEnabled) {
                this.yoga_scrollViewFixPostLayout(subview)
            }
        }
    }
}

fun addSubview(view: UIView, content: (() -> Unit)? = null) {
    HostingController.views.last().addSubview(view)
    HostingController.views.add(view)
    content?.invoke()
    HostingController.views.removeLast()
}

fun addController(controller: UIViewController, content: (() -> Unit)? = null) {
    HostingController.controllers.add(controller)
    HostingController.views.add(controller.view)
    content?.invoke()
    HostingController.views.removeLast()
    HostingController.controllers.removeLast()
}

fun getHostingView(): HostingView {
    return HostingController.views.first() as HostingView
}

fun getCurrentView(): UIView {
    return HostingController.views.last()
}

fun getCurrentController(): UIViewController {
    return HostingController.controllers.last()
}

fun refreshContent() {
    HostingController.host.refreshContent()
}

fun addControllerAndLayout(controller: UIComposeViewController) {
    HostingController.host.removeSubViews(controller)
    addController(controller, controller.content)
    HostingController.host.removeDirtySubViews(controller)
    HostingController.host.yoga_applyLayout(controller)
}
