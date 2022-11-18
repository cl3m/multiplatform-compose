package com.rouge41.kmm.compose.test.demos

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//FROM https://raw.githubusercontent.com/vinaygaba/Learn-Jetpack-Compose-By-Example/master/app/src/main/java/com/example/jetpackcompose/text/TextFieldActivity.kt

@Composable
internal fun TextFields() {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text("This is a filled TextInput field based on Material Design")
        MaterialTextInputComponent()
    }
}


@Composable
internal fun MaterialTextInputComponent() {
    var textValue by remember { mutableStateOf("") }

    Text("Text is ${textValue}", modifier = Modifier)
    Spacer(modifier = Modifier.height(10.dp))
    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text("Enter Your Name") },
        placeholder = { Text(text = "John Doe") }
    )
}