package com.rouge41.kmm.compose.test.demos

import com.rouge41.kmm.compose.*

// FROM https://raw.githubusercontent.com/vinaygaba/Learn-Jetpack-Compose-By-Example/master/app/src/main/java/com/example/jetpackcompose/material/AlertDialogActivity.kt

@Composable
fun Alert() {
    Column {
        // Here, ClickableText is a @Composable function which is going to describe the
        // contents of this activity that will be rendered on the screen.
        ClickableText()
    }
}


// We represent a Composable function by annotating it with the @Composable annotation. Composable
// functions can only be called from within the scope of other composable functions. We should
// think of composable functions to be similar to lego blocks - each composable function is in turn
// built up of smaller composable functions.
@Composable
fun ClickableText() {
    // Reacting to state changes is core to how Jetpack Compose works. This state variable "showPopup"
    // is used to control whether the popup should be shown. The value is toggled every time the
    // text "Click to see dialog" is clicked. Every time the value of this variable changes,
    // the relevant sub-composables that use showPopup are automatically recomposed.
    var variable by remember { mutableStateOf("not clicked") }
    var showPopup by remember { mutableStateOf(false) }
    // Column with clickable modifier wraps the child composable and enables it to react to a click
    // through the onClick callback similar to the onClick listener that we are accustomed to
    // on Android.
    // Here, we just change the value of showPopup to be true every time we click on the text that
    // says "Click to see Popup"
    Button(onClick = { showPopup = true }, content = {
        // The Text composable is pre-defined by the Compose UI library; you can use this
        // composable to render text on the screen
        Text(
            text = "Click to see dialog", modifier = Modifier.padding(16.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily.Serif
            )
        )
    })

    Text(if (showPopup) "ShowPopup = true" else "ShopPopup = false")
    Text(variable)

    // A lambda that toggles the showPopup value to off. We pass it to the onDismiss equivalent
    // callback of the AlertDialog.
    val onPopupDismissed = { showPopup = false }

    // We want to show the popup only if the showPopup variable is toggled to true. Since Jetpack
    // Compose uses the declarative way of programming, we can easily decide what needs to shows
    // vs hidden based on which branch of code is being executed. In this example, we display the
    // AlertDialog only when the showPopup variable is set to true or else this branch is not
    // executed at all and thus the alert dialog remains hidden.
    if (showPopup) {
        // Predefined composable provided by the material implementations of Jetpack Compose. It
        // shows a simple alert dialog on the screen if this code path is executed (i.e showPopup
        // variable is true)
        AlertDialog(
            onDismissRequest = onPopupDismissed,
            title = {
                Text("Confirmation")
            },
            text = {
                Text("Congratulations! You just clicked the text successfully")
            },
            dismissButton = {
                Button(
                    onClick = {
                        onPopupDismissed()
                        variable = "Cancel clicked"
                    }
                ) {
                    Text(text = "Cancel")
                }
            }
            ,confirmButton = {
                // Button is a pre-defined Material Design implementation of a contained button -
                // https://material.io/design/components/buttons.html#contained-button.
                Button(
                    onClick = {
                        onPopupDismissed()
                        variable = "Ok clicked"
                    }
                ) {
                    // The Button composable allows you to provide child composables that inherit
                    // this button functionality.
                    // The Text composable is pre-defined by the Compose UI library; you can use this
                    // composable to render text on the screen
                    Text(text = "Ok")
                }
            })
    }
}