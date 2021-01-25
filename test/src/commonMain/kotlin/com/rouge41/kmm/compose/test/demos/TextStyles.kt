package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.foundation.isSystemInDarkTheme
import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.text.TextStyle
import com.rouge41.kmm.compose.ui.text.font.FontFamily
import com.rouge41.kmm.compose.ui.text.font.FontStyle
import com.rouge41.kmm.compose.ui.text.font.FontWeight
import com.rouge41.kmm.compose.ui.unit.sp

@Composable
fun TextStyles() {
    Text("I am Custom Color Blue", style = TextStyle(color = Color.Blue))
    // place yuor fonts into the fonts folder inside res folder
    // Text("I am Custom Font Montserrat", style = TextStyle(fontFamily = FontFamily(Font(name="montserrat_semibold.otf"))))
    // font style is italic here
    Text("I am Italic", style = TextStyle(fontStyle = FontStyle.Italic))
    // Weight is Bold
    Text("I am BOLD", style = TextStyle(fontWeight = FontWeight.Bold))
    // Set the font size inside the TextStyle
    Text("I am Large Text", style = TextStyle(fontSize = 25.sp))
    // This is normal simpler way to write the text
    Text("But We are all Custom  Made Fonts")
    // More
    Text("I am Cursive Text", style = TextStyle(fontFamily = FontFamily.Cursive))
    Text("I am Monospace Text", style = TextStyle(fontFamily = FontFamily.Monospace))
    Text("I am Serif Text", style = TextStyle(fontFamily = FontFamily.Serif))
    Text("Big text", fontSize = 30.sp)
    Text("Red text", color = Color.Red)
    val darkTheme = isSystemInDarkTheme()
    if (darkTheme) {
        Text("I'm dark text color", color = Color.Green)
    } else {
        Text("I'm light text color", color = Color.Cyan)
    }

}
