package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*
import com.rouge41.kmm.compose.foundation.layout.Column
import com.rouge41.kmm.compose.foundation.layout.Spacer
import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.material.TextField
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.runtime.mutableStateOf
import com.rouge41.kmm.compose.runtime.*
import com.rouge41.kmm.compose.ui.*
import com.rouge41.kmm.compose.ui.graphics.Color
import com.rouge41.kmm.compose.ui.unit.dp

//FROM https://raw.githubusercontent.com/vinaygaba/Learn-Jetpack-Compose-By-Example/master/app/src/main/java/com/example/jetpackcompose/text/TextFieldActivity.kt

@Composable
fun TextFields() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text("This is a filled TextInput field based on Material Design")
        MaterialTextInputComponent()
    }
}


@Composable
fun MaterialTextInputComponent() {
    var textValue by remember { mutableStateOf("") }

    Text("Text is ${textValue}", modifier = Modifier)
    Spacer(modifier = Modifier.preferredHeight(10.dp))
    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text("Enter Your Name") },
        placeholder = { Text(text = "John Doe") }
    )
}