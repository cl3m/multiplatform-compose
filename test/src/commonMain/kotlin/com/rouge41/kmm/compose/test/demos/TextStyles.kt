package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*

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

}
