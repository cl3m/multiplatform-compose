package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*

//FROM https://raw.githubusercontent.com/vinaygaba/Learn-Jetpack-Compose-By-Example/master/app/src/main/java/com/example/jetpackcompose/text/TextFieldActivity.kt

@Composable
fun TextFields() {
    Column(modifier = Modifier.fillMaxWidth()) {
        TitleComponent("This is a filled TextInput field based on Material Design")
        MaterialTextInputComponent()
    }
}


@Composable
fun MaterialTextInputComponent() {
    var textValue by remember { mutableStateOf("") }

    Text("Text is ${textValue}", modifier = Modifier.padding(16.dp))
    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text("Enter Your Name") },
        placeholder = { Text(text = "John Doe") },
        modifier = Modifier.background(Color.LightGray).padding(16.dp).fillMaxWidth()
    )
}