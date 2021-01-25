package com.rouge41.kmm.compose.material

import com.rouge41.kmm.compose.ui.text.font.FontFamily
import com.rouge41.kmm.compose.ui.text.font.FontWeight
import com.rouge41.kmm.compose.ui.text.TextStyle
import com.rouge41.kmm.compose.ui.unit.sp

expect class Typography {
    val h1: TextStyle
    val h2: TextStyle
    val h3: TextStyle
    val h4: TextStyle
    val h5: TextStyle
    val h6: TextStyle
    val subtitle1: TextStyle
    val subtitle2: TextStyle
    val body1: TextStyle
    val body2: TextStyle
    val button: TextStyle
    val caption: TextStyle
    val overline: TextStyle

    constructor(
            defaultFontFamily: FontFamily = FontFamily.Default,
            h1: TextStyle = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 96.sp,
                    letterSpacing = (-1.5).sp
            ),
            h2: TextStyle = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 60.sp,
                    letterSpacing = (-0.5).sp
            ),
            h3: TextStyle = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 48.sp,
                    letterSpacing = 0.sp
            ),
            h4: TextStyle = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 34.sp,
                    letterSpacing = 0.25.sp
            ),
            h5: TextStyle = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 24.sp,
                    letterSpacing = 0.sp
            ),
            h6: TextStyle = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    letterSpacing = 0.15.sp
            ),
            subtitle1: TextStyle = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    letterSpacing = 0.15.sp
            ),
            subtitle2: TextStyle = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    letterSpacing = 0.1.sp
            ),
            body1: TextStyle = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    letterSpacing = 0.5.sp
            ),
            body2: TextStyle = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp
            ),
            button: TextStyle = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    letterSpacing = 1.25.sp
            ),
            caption: TextStyle = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    letterSpacing = 0.4.sp
            ),
            overline: TextStyle = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    letterSpacing = 1.5.sp
            )
    )
}