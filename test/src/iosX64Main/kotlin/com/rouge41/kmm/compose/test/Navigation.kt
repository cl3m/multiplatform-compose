package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*
import com.rouge41.kmm.compose.test.demos.*
import platform.Foundation.NSLog

@Composable
actual fun Navigation(state: MutableState<Boolean>, resources: Resources) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Main") {
        composable("Main", "Navigation", leadingButton = {
            Button( onClick = {
                NSLog("🎉 Leading")
            }) { Text ("Leading") }
        }, trailingButton = {
            Button( onClick = {
                NSLog("🎉 Trailing")
            }) { Text ("Trailing") }
        }) {
            SafeArea {
                Menu(state) { route ->
                    navController.navigate(route)
                }
                ListItem(
                    text = { Text("Raw mode") },
                    modifier = Modifier.clickable(
                        onClick = {
                            //hacky way because state is not so good
                            for (key in cache.keys) {
                                if (key.contains("rememberNavController")) {
                                    cache.remove(key)
                                    break
                                }
                            }
                            state.value = false
                        }
                    )
                )
            }
        }
        Demo.values().dropLast(4).forEach { screen ->
            composable(screen.toString(), screen.toString()) {
                when (screen) {
                    Demo.LazyColumn -> SafeArea { LazyColumn() }
                    Demo.HelloPlatform -> SafeArea { HelloPlatform() }
                    Demo.Lorem -> SafeArea { ScrollableColumn { Lorem() } }
                    Demo.Counter -> Counter()
                    Demo.PeopleInSpace -> SafeArea { Text("Go through Raw first") }
                    Demo.BackPress -> BackPress()
                    Demo.Layout -> SafeArea { Layout() }
                    Demo.Buttons -> SafeArea { Buttons() }
                    Demo.Images ->  SafeArea { Images(resources) }
                    Demo.Alert -> SafeArea { Alert() }
                    Demo.TextStyles -> SafeArea { Column { TextStyles() } }
                    Demo.TextFields -> SafeArea { TextFields() }
                }
            }
        }
    }
}