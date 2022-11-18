[![Kotlin Multiplatform](https://img.shields.io/static/v1?logo=Kotlin&&logoColor=3c94cf&label=&message=Kotlin%20Multiplatform&color=555)](https://kotlinlang.org/docs/reference/multiplatform.html)

# Multiplatform Compose

A demo to show usage of Jetbrains Compose in Android and iOS. Originally a Jetpack Compose implementation with native view and yoga for iOS.

## Table of contents

- [Libraries](#libraries)
- [Demos](#demos)
- [Troubleshooting](#troubleshooting)
- [Alternatives](#alternatives)
- [License](#license)

## Libraries

- kotlinx coroutines
- ktor
- Jetbrains Compose (uikit experimental)
- [PreCompose](https://github.com/Tlaster/PreCompose) (for navigation)

## Demos

Run the app to see a demo of compose on ios.

![Demos](https://github.com/cl3m/multiplatform-compose/blob/compose-jb/screenshots/Demos.png?raw=true)

#### AsyncImage

The image composable allow url loading

```kotlin
AsyncImage(url = "https://loremflickr.com/320/240/ocean", modifier = Modifier.size(200.dp))
```

#### SafeArea

SafeArea.current to get PaddingValues.

#### DarkMode

DarkMode.current to fix dark mode on iOS.


## Troubleshooting

### e: java.lang.IllegalStateException: No file for ***

Compose function and CompositonLocal have to be internal and not exposed to iOS module.

## Alternatives

- [Compose Multiplatform by JetBrains](https://github.com/JetBrains/compose-jb) started native support via Skia ([Skiko](https://github.com/JetBrains/skiko)), you can have a look at the [sample](https://github.com/JetBrains/compose-jb/tree/master/experimental/examples/falling-balls-mpp). Touchlab made a demo for [Droidcon NYC App](https://touchlab.co/droidcon-nyc-ios-app-with-compose/) It will use the compose compiler but not native component.  

- [Redwood Compose](https://github.com/cashapp/redwood) by Cash App. [Native UI with multiplatform Compose](https://jakewharton.com/native-ui-with-multiplatform-compose/). Use the compose compiler and native iOS component. 

- [Platform-Kit by IceRock](https://github.com/Alex009/compose-jb/tree/platform-kit-sample/examples/common-platform-uikit) based on Compose Multiplatform by JetBrains, add support via UIKit, thus use the compose compiler and native iOS component.  

- [multiplatform-compose](https://github.com/cl3m/multiplatform-compose/tree/yoga) This original repo, an experiment with native view and yoga for layout. You can also have a look at [kmp-redux](https://github.com/cl3m/kmp-redux/tree/skiko) that show Compose integration with SwiftUI. 


## License

    Copyright 2021 Clément Beffa
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
