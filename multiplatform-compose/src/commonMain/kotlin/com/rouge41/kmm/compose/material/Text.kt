package com.rouge41.kmm.compose.material

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

@Composable
expect fun Text(
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
    /*onTextLayout: (TextLayoutResult) -> Unit = {},*/
    style: TextStyle? = null
)