package com.rouge41.kmm.compose.ui.text.input

actual interface VisualTransformation {
    actual companion object {
        actual val None: VisualTransformation
            get() = iosVisualTransformation()
    }
}

class iosVisualTransformation: VisualTransformation