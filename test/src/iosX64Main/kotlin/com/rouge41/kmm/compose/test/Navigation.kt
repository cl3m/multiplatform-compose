package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.navigation.*
import com.rouge41.kmm.compose.foundation.layout.Column
import com.rouge41.kmm.compose.foundation.lazy.LazyColumn
import com.rouge41.kmm.compose.ios.SafeArea
import com.rouge41.kmm.compose.material.Button
import com.rouge41.kmm.compose.material.Divider
import com.rouge41.kmm.compose.material.ListItem
import com.rouge41.kmm.compose.material.Text
import com.rouge41.kmm.compose.runtime.Composable
import com.rouge41.kmm.compose.runtime.MutableState
import com.rouge41.kmm.compose.test.demos.*
import com.rouge41.kmm.compose.ui.*
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
                LazyColumn {
                    items(Demo.values().dropLast(4)) { item ->
                        Text(
                            item.toString(),
                            modifier = Modifier.clickable { navController.navigate(item.toString()) })
                        Divider()
                    }
                    item {
                        Text(
                            "Raw mode",
                            modifier = Modifier.clickable { state.value = false })
                    }
                }
            }
        }
        Demo.values().dropLast(4).forEach { screen ->
            composable(screen.toString(), screen.toString()) {
                when (screen) {
                    Demo.LazyColumn -> SafeArea { LazyCol() }
                    Demo.HelloPlatform -> SafeArea { HelloPlatform() }
                    Demo.Lorem -> SafeArea { Lorem() }
                    Demo.Counter -> Counter()
                    Demo.BackPress -> BackPress()
                    Demo.Layout -> SafeArea { Layout() }
                    Demo.Buttons -> SafeArea { Buttons() }
                    Demo.Images ->  SafeArea { Images(resources) }
                    Demo.Alert -> SafeArea { Alert() }
                    Demo.TextStyles -> SafeArea { Column { TextStyles() } }
                    Demo.TextFields -> SafeArea { TextFields() }
                    Demo.Board2048 -> SafeArea { Board2048() }
                }
            }
        }
    }
}