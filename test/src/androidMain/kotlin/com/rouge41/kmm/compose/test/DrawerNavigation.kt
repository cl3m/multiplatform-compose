package com.rouge41.kmm.compose.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.rouge41.kmm.compose.runtime.MutableState
import com.rouge41.kmm.compose.ui.clickable
import com.rouge41.kmm.compose.test.demos.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DrawerNavigation(state: MutableState<Boolean>, resources: Resources) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navController.currentBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentRoute ?: "") },
                navigationIcon = {
                    Icon(
                        Icons.Default.Menu,
                        "test",
                        modifier = Modifier.clickable(
                            onClick = {
                                scope.launch { scaffoldState.drawerState.open() }
                            }
                        )
                    )
                }
            )
        },
        drawerContent = {
            LazyColumn {
                items(Demo.values().size - 4) {
                    val item = Demo.values()[it]
                    ListItem(text = { Text(item.toString()) }, modifier = Modifier.clickable {
                        navController.navigate(item.toString()) {
                            launchSingleTop = true
                        }
                        scope.launch { scaffoldState.drawerState.close() }
                    })
                    Divider()
                }
                item {
                    ListItem(
                        text = { Text("Raw mode") },
                        modifier = Modifier.clickable(
                            onClick = {
                                state.value = false
                            }
                        )
                    )
                  //  Spacer(modifier = Modifier.preferredHeight(60.dp))
                }
            }

        },
        scaffoldState = scaffoldState
    ) {
        NavHost(navController, startDestination = Demo.values().first().toString()) {
            Demo.values().dropLast(4).forEach { screen ->
                composable(screen.toString()) {
                    when (screen) {
                        Demo.LazyColumn -> LazyCol()
                        Demo.HelloPlatform -> HelloPlatform()
                        Demo.Lorem -> Lorem()
                        Demo.Counter -> Counter()
                        Demo.BackPress -> BackPress()
                        Demo.Layout -> Layout()
                        Demo.Images ->  Images(resources)
                        Demo.Buttons ->  Buttons()
                        Demo.Alert ->  Alert()
                        Demo.TextStyles -> Column { TextStyles() }
                        Demo.TextFields -> TextFields()
                        Demo.Board2048 -> Board2048()
                    }
                }
            }
        }
    }
}

@Composable
actual fun Navigation(state: MutableState<Boolean>, resources: Resources) = DrawerNavigation(state, resources)