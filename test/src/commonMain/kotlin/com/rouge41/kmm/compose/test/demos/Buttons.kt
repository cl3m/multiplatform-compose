package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*

// From https://github.com/vinaygaba/Learn-Jetpack-Compose-By-Example/blob/master/app/src/main/java/com/example/jetpackcompose/material/ButtonActivity.kt

@Composable
fun Buttons() {
    // Column is a composable that places its children in a vertical sequence. You
    // can think of it similar to a LinearLayout with the vertical orientation.

    // You can think of Modifiers as implementations of the decorators pattern that are used to
    // modify the composable that its applied to. In the example below, we configure the
    // column to occupy the entire available height & width using the Modifier.fillMaxSize()
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleButtonComponent()
        SimpleButtonWithBorderComponent()
        RoundedCornerButtonComponent()
        OutlinedButtonComponent()
        TextButtonComponent()
        Button(
            modifier = Modifier.padding(16.dp).background(Color.Green),
            elevation = null,
            colors = ButtonDefaults.textButtonColors(),
            onClick = {}) {
            Text(text = "Big Button", modifier = Modifier.padding(16.dp), fontSize = 30.sp, color = Color.Red)
        }
        Counter(modifier = Modifier.height(200.dp))
    }
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun SimpleButtonComponent() {
    // Button is a pre-defined Material Design implementation of a contained button -
    // https://material.io/design/components/buttons.html#contained-button.

    // You can think of Modifiers as implementations of the decorators pattern that are used to
    // modify the composable that its applied to. In this example, we assign a padding of
    // 16dp to the Button.
    Button(
        modifier = Modifier.padding(16.dp),
        // elevation = ButtonDefaults.elevation(5.dp),
        onClick = {}) {
        // The Button composable allows you to provide child composables that inherit this button
        // functionality.
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(text = "Simple button", modifier = Modifier.padding(16.dp))
    }
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun SimpleButtonWithBorderComponent() {
    // Button is a pre-defined Material Design implementation of a contained button -
    // https://material.io/design/components/buttons.html#contained-button.

    // You can think of Modifiers as implementations of the decorators pattern that are used to
    // modify the composable that its applied to. In this example, we assign a padding of
    // 16dp to the Button.
    Button(
        onClick = {},
        modifier = Modifier.padding(16.dp),
        elevation = ButtonDefaults.elevation(5.dp),
        // Provide a border for this button
        border = BorderStroke(width = 5.dp, brush = SolidColor(Color.Black))
    ) {
        // The Button composable allows you to provide child composables that inherit this button
        // functionality.
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(text = "Simple button with border", modifier = Modifier.padding(16.dp))
    }
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun RoundedCornerButtonComponent() {
    // Button is a pre-defined Material Design implementation of a contained button -
    // https://material.io/design/components/buttons.html#contained-button.

    // You can think of Modifiers as implementations of the decorators pattern that are used to
    // modify the composable that its applied to. In this example, we assign a padding of
    // 16dp to the Button.
    Button(
        onClick = {},
        modifier = Modifier.padding(16.dp),
        // Provide a custom shape for this button. In this example. we specify the button to have
        // round corners of 16dp radius.
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.elevation(5.dp),
    ) {
        // The Button composable allows you to provide child composables that inherit this button
        // functionality.
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(text = "Button with rounded corners", modifier = Modifier.padding(16.dp))
    }
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun OutlinedButtonComponent() {
    // Button is a pre-defined Material Design implementation of a outlined button -
    // https://material.io/design/components/buttons.html#outlined-button.

    // You can think of Modifiers as implementations of the decorators pattern that are used to
    // modify the composable that its applied to. In this example, we assign a padding of
    // 16dp to the Button.
    OutlinedButton(
        onClick = {},
        modifier = Modifier.padding(16.dp)
    ) {
        // The Button composable allows you to provide child composables that inherit this button
        // functionality.
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(text = "Outlined Button", modifier = Modifier.padding(16.dp))
    }
}

// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun TextButtonComponent() {
    // Button is a pre-defined Material Design implementation of a text button -
    // https://material.io/design/components/buttons.html#text-button.

    // You can think of Modifiers as implementations of the decorators pattern that are used to
    // modify the composable that its applied to. In this example, we assign a padding of
    // 16dp to the Button.
    TextButton(
        onClick = {},
        modifier = Modifier.padding(16.dp)
    ) {
        // The Button composable allows you to provide child composables that inherit this button
        // functionality.
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(text = "Text Button", modifier = Modifier.padding(16.dp))
    }
}