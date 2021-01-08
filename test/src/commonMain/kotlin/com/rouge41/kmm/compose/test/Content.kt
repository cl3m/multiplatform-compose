package com.rouge41.kmm.compose.test

import com.rouge41.kmm.compose.*

data class Resources(val logo: ImageResource)

@Composable
fun Content(resources: Resources) {
    Theme {
        val state = remember { ContentState() }
        when (state.current) {
            ContentType.Root -> SafeArea { Root(state) }
            ContentType.HelloPlatform -> SafeArea { HelloPlatform() }
            ContentType.Lorem -> SafeArea { ScrollableColumn { Lorem() } }
            ContentType.Counter -> SafeArea { Counter() }
            ContentType.BackPress -> SafeArea { BackPress() }
            ContentType.Layout -> SafeArea { Layout() }
            ContentType.TextStyles -> SafeArea { TextStyles() }
            ContentType.Images -> SafeArea { Images(resources) }
            ContentType.BottomNavigation -> BottomNavigation()
            ContentType.Navigation -> Navigation(resources)
        }
    }
}

@Composable
fun Root(state: ContentState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Text("ROOT")
        Button(modifier = Modifier.background(Color.Green).fillMaxWidth(), onClick = { state.current = ContentType.Navigation }, colors = ButtonDefaults.buttonColors()) { Text("Navigation", style = TextStyle(color = Color.White)) }
        Spacer(modifier = Modifier.preferredHeight(16.dp))
        for (content in contents()) {
            Button(onClick = { state.current = content }) { Text(content.toString()) }
            Spacer(modifier = Modifier.preferredHeight(16.dp))
        }
    }
}

class ContentState {
    var current by mutableStateOf(ContentType.Root)
}

enum class ContentType {
    Root,
    HelloPlatform,
    Lorem,
    Counter,
    BackPress,
    Layout,
    TextStyles,
    Images,
    BottomNavigation,
    Navigation
}

fun contents() = ContentType.values().toMutableList().drop(1).dropLast(1)