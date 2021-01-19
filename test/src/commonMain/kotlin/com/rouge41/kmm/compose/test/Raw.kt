package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*
import com.rouge41.kmm.compose.test.demos.*

@Composable
fun Raw(state: MutableState<Boolean>, resources: Resources) {
    var demoState = remember { mutableStateOf(Demo.Raw) }
    when (demoState.value) {
        Demo.Raw -> SafeArea { RawDemos(demoState) }
        Demo.HelloPlatform -> SafeArea { HelloPlatform() }
        Demo.Lorem -> SafeArea { ScrollableColumn { Lorem() } }
        Demo.LazyColumn -> LazyColumn()
        Demo.PeopleInSpace -> PeopleInSpace()
        Demo.Counter -> SafeArea { Counter() }
        Demo.BackPress -> SafeArea { BackPress() }
        Demo.Layout -> SafeArea { Layout() }
        Demo.TextStyles -> SafeArea { TextStyles() }
        Demo.Images -> SafeArea { Images(resources) }
        Demo.Buttons ->  SafeArea { Buttons() }
        Demo.BottomNavigation -> BottomNavigation(state, resources)
        Demo.Navigation -> Navigation(state, resources)
    }
}

@Composable
fun RawDemos(demoState: MutableState<Demo>) {
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start) {
        Text("RAW")
        for (content in Demo.values().dropLast(2)) {
            Button(onClick = { demoState.value = content }) { Text(content.toString()) }
            Spacer(modifier = Modifier.preferredHeight(16.dp))
        }
    }
}