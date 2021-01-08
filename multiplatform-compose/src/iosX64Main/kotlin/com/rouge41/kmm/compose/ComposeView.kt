package com.rouge41.kmm.compose

import cocoapods.YogaKit.*
import kotlinx.cinterop.CValue
import kotlinx.cinterop.cValue
import kotlinx.cinterop.useContents
import platform.CoreGraphics.*
import platform.Foundation.NSLog
import platform.UIKit.*
import kotlin.reflect.KClass

/* Mixing Kotlin and Objective-C supertypes is not supported
interface ComposeView {
    var isDirty: Boolean
    var identifier: String
}*/

class UIComposeView(val contentIdentifier: String) : UIView(frame = cValue { CGRectZero }) {
    var isDirty: Boolean = false

    companion object {
        fun createOrReuse(contentIdentifier: String): UIComposeView {
            for (view in getCurrentView().subviews) {
                if (view is UIComposeView && view.isDirty && view.contentIdentifier == contentIdentifier) {
                    view.isDirty = false
                    return view
                }
            }
            return UIComposeView(contentIdentifier)
        }
    }
}

class UIComposeScrollView(val contentIdentifier: String) : UIScrollView(frame = cValue { CGRectZero }) {
    var isDirty: Boolean = false

    companion object {
        fun createOrReuse(contentIdentifier: String): UIComposeScrollView {
            for (view in getCurrentView().subviews) {
                if (view is UIComposeScrollView && view.isDirty && view.contentIdentifier == contentIdentifier) {
                    view.isDirty = false
                    return view
                }
            }
            return UIComposeScrollView(contentIdentifier)
        }
    }
}