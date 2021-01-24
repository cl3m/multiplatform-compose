package com.rouge41.kmm.compose.test

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.navigation.compose.*
import com.rouge41.kmm.compose.MutableState
import com.rouge41.kmm.compose.SafeArea
import com.rouge41.kmm.compose.ScrollableColumn
import com.rouge41.kmm.compose.clickable
import com.rouge41.kmm.compose.test.demos.*

@Composable
fun DrawerNavigation(state: MutableState<Boolean>, resources: Resources) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentRoute ?: "") },
                navigationIcon = {
                    Icon(
                        Icons.Default.Menu,
                        modifier = Modifier.clickable(
                            onClick = {
                                scaffoldState.drawerState.open()
                            }
                        )
                    )
                }
            )
        },
        drawerContent = {
            Menu(state) { route ->
                navController.navigate(route) {
                    launchSingleTop = true
                }
                scaffoldState.drawerState.close()
            }
            ListItem(
                text = { Text("Raw mode") },
                modifier = Modifier.clickable(
                    onClick = {
                        state.value = false
                    }
                )
            )
        },
        scaffoldState = scaffoldState
    ) {
        NavHost(navController, startDestination = Demo.values().first().toString()) {
            Demo.values().dropLast(4).forEach { screen ->
                composable(screen.toString()) {
                    when (screen) {
                        Demo.LazyColumn -> LazyColumn()
                        Demo.HelloPlatform -> HelloPlatform()
                        Demo.Lorem -> ScrollableColumn { Lorem() }
                        Demo.Counter -> Counter()
                        Demo.PeopleInSpace -> PeopleInSpace()
                        Demo.BackPress -> BackPress()
                        Demo.Layout -> Layout()
                        Demo.Images ->  Images(resources)
                        Demo.Buttons ->  Buttons()
                        Demo.Alert ->  Alert()
                        Demo.TextStyles -> Column { TextStyles() }
                        Demo.TextFields -> TextFields()
                    }
                }
            }
        }
    }
}

@Composable
actual fun Navigation(state: MutableState<Boolean>, resources: Resources) = DrawerNavigation(state, resources)