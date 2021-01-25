package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.foundation.layout.Arrangement
import com.rouge41.kmm.compose.foundation.layout.Column
import com.rouge41.kmm.compose.foundation.layout.Row
import com.rouge41.kmm.compose.foundation.layout.Spacer
import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.ui.*
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.text.TextStyle
import com.rouge41.kmm.compose.ui.unit.dp

@Composable
fun Layout() {
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
