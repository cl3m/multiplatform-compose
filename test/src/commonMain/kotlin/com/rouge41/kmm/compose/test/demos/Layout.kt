package com.rouge41.kmm.compose.test.demos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
internal fun Layout() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Magenta),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text("Layout is the new Blue.", modifier = Modifier.background(Color.Blue), style = TextStyle(color = Color.White))
            Text("Green.", modifier = Modifier.background(Color.Green))
            Row(
                modifier = Modifier.fillMaxWidth().background(Color.Yellow),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                content = {
                    Spacer(modifier = Modifier.background(Color.Red).height(30.dp).width(50.dp))
                    Spacer(modifier = Modifier.background(Color.Black).height(50.dp).width(30.dp))
                    Spacer(modifier = Modifier.background(Color.Blue).height(10.dp).width(10.dp))
                }
            )
        }
    )
}
