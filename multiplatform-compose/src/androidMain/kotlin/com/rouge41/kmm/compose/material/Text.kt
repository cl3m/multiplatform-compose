package com.rouge41.kmm.compose.material

import androidx.compose.material.AmbientTextStyle
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.text.style.TextOverflow
import com.rouge41.kmm.compose.ui.Modifier
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.text.TextAlign
import com.rouge41.kmm.compose.ui.text.TextDecoration
import com.rouge41.kmm.compose.ui.text.TextStyle
import com.rouge41.kmm.compose.ui.text.font.FontFamily
import com.rouge41.kmm.compose.ui.text.font.FontStyle
import com.rouge41.kmm.compose.ui.text.font.FontWeight
import com.rouge41.kmm.compose.ui.unit.TextUnit
import androidx.compose.material.Text as _Text

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual fun Text(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = Color.Unspecified,
        fontSize: TextUnit = TextUnit.Unspecified,
        fontStyle: FontStyle? = null,
        fontWeight: FontWeight? = null,
        fontFamily: FontFamily? = null,
        letterSpacing: TextUnit = TextUnit.Unspecified,
        textDecoration: TextDecoration? = null,
        textAlign: TextAlign? = null,
        lineHeight: TextUnit = TextUnit.Unspecified,
        overflow: TextOverflow = TextOverflow.Clip,
        softWrap: Boolean = true,
        maxLines: Int = Int.MAX_VALUE,
    /*onTextLayout: (TextLayoutResult) -> Unit = {},*/ // Mess with compose compiler
        style: TextStyle? = null
) = _Text(text = text, modifier = modifier, color = color, fontSize = fontSize, fontStyle = fontStyle,
    fontWeight = fontWeight, fontFamily = fontFamily, letterSpacing = letterSpacing, textDecoration = textDecoration,
    textAlign = textAlign, lineHeight = lineHeight, overflow = overflow, softWrap = softWrap, maxLines = maxLines, style = style ?: AmbientTextStyle.current)