package com.rouge41.kmm.compose.ios

import cocoapods.YogaKit.*
import com.rouge41.kmm.compose.foundation.ComposeImageView
import com.rouge41.kmm.compose.material.ComposeLabel
import com.rouge41.kmm.compose.material.ComposeSystemButton
import com.rouge41.kmm.compose.material.ComposeTextField
import com.rouge41.kmm.compose.navigation.NavBackStackEntry
import com.rouge41.kmm.compose.navigation.UIComposeNavigationController
import com.rouge41.kmm.compose.navigation.UIComposeViewController
import com.rouge41.kmm.compose.runtime.Composable
import kotlinx.cinterop.CValue
import kotlinx.cinterop.useContents
import platform.CoreGraphics.CGSize
import platform.CoreGraphics.CGSizeMake
import platform.UIKit.*
import kotlin.math.max

val DEBUG_COMPOSE = false

open class HostingController(val controller: UIViewController, val content: @Composable () -> Unit, val imageViewLoader: (UIImageView, String) -> Unit) {
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

    fun removeSubViews(view: UIView) {
        for (subview in view.subviews) {
            when (subview) {
                is UIComposeView -> {
                    subview.isDirty = true
                    removeSubViews(subview)
                }
                is UIComposeScrollView -> {
                    subview.isDirty = true
                    removeSubViews(subview)
                }
                is ComposeImageView -> {
                    subview.isDirty = true
                }
                is ComposeSystemButton -> {
                    subview.isDirty = true
                }
                is ComposeLabel -> {
                    subview.isDirty = true
                }
                is ComposeTextField -> {
                    subview.isDirty = true
                }
                else -> {
                    (subview as UIView).tag = -1L
                }
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

    fun removeDirtySubViews(view: UIView) {
        for (subview in view.subviews) {
            if (subview is UIComposeView && subview.isDirty) {
                subview.removeFromSuperview()
            } else if (subview is UIComposeScrollView && subview.isDirty) {
                subview.removeFromSuperview()
            } else if (subview is ComposeImageView && subview.isDirty) {
                subview.removeFromSuperview()
            } else if (subview is ComposeSystemButton && subview.isDirty) {
                subview.removeFromSuperview()
            } else if (subview is ComposeLabel && subview.isDirty) {
                subview.removeFromSuperview()
            } else if (subview is ComposeTextField && subview.isDirty) {
                subview.removeFromSuperview()
            } else if (subview is UIView && subview.tag == -1L) {
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

    fun yoga_applyLayout(view: UIView) {
        if (view is UITableView) {
            return
        }
        this.yoga_scrollViewFixPreLayout(view)
        view.yoga.applyLayoutPreservingOrigin(true)
        this.yoga_scrollViewFixPostLayout(view)
        this.tableViewsLayout(view)
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
            view.setContentSize(contentSize(view))
        }
        for (subview in view.subviews) {
            if (subview is UIView && subview.isYogaEnabled) {
                this.yoga_scrollViewFixPostLayout(subview)
            }
        }
    }

    private fun tableViewsLayout(view: UIView) {
        if (view is UITableView && view.superview != null) {
            view.setFrame(view.superview!!.bounds)
        }
        for (subview in view.subviews) {
            if (subview is UIView) {
                this.tableViewsLayout(subview)
            }
        }
    }
}

fun contentSize(view: UIView): CValue<CGSize> {
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
    return CGSizeMake(w, h)
}

fun addSubview(view: UIView, content: (() -> Unit)? = null) {
    HostingController.views.last().addSubview(view)
    HostingController.views.add(view)
    content?.invoke()
    HostingController.views.removeLast()
}

fun addController(controller: UIViewController?, content: (@Composable (NavBackStackEntry) -> Unit)? = null) {
    controller?.let {
        HostingController.controllers.add(it)
        HostingController.views.add(it.view)
    }
    if (controller is UIComposeViewController) {
        content?.invoke(com.rouge41.kmm.compose.navigation.NavBackStackEntry(controller.bundle))
    } else {
        content?.invoke(com.rouge41.kmm.compose.navigation.NavBackStackEntry())
    }
    controller?.let {
        HostingController.views.removeLast()
        HostingController.controllers.removeLast()
    }
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

fun addViewAndLayout(view: UIView, content: (() -> Unit)? = null) {
    HostingController.host.removeSubViews(view)
    HostingController.views.add(view)
    content?.invoke()
    HostingController.views.removeLast()
    HostingController.host.removeDirtySubViews(view)
    HostingController.host.yoga_applyLayout(view)
}
