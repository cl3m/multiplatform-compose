package com.rouge41.kmm.compose.ui.unit

import androidx.compose.ui.unit.sp as _sp

actual typealias TextUnit = androidx.compose.ui.unit.TextUnit

actual inline val Int.sp: TextUnit get() = this._sp
actual inline val Double.sp: TextUnit get() = this._sp