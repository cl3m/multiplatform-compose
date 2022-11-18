[![Kotlin Multiplatform](https://img.shields.io/static/v1?logo=Kotlin&&logoColor=3c94cf&label=&message=Kotlin%20Multiplatform&color=555)](https://kotlinlang.org/docs/reference/multiplatform.html)

:warning:  This PoC compile on iOS and Android but I've remove some functionality because Compose changed too much since I started it. I will update it using the compose compiler when it will be possible. There are some hope on the way :
- [Redwood Compose](https://github.com/cashapp/redwood) by Cash App. [Native UI with multiplatform Compose](https://jakewharton.com/native-ui-with-multiplatform-compose/). Use the compose compiler and native iOS component. 
- [Compose Multiplatform by JetBrains](https://github.com/JetBrains/compose-jb) started native support via Skia ([Skiko](https://github.com/JetBrains/skiko)), you can have a look at the [sample](https://github.com/JetBrains/compose-jb/tree/master/experimental/examples/falling-balls-mpp) but it is still very early. Some of the demos in this repo works but there is still many broken functionality. Touchlab made a demo for [Droidcon NYC App](https://touchlab.co/droidcon-nyc-ios-app-with-compose/) It will use the compose compiler but not native component.  
- [Platform-Kit by IceRock](https://github.com/Alex009/compose-jb/tree/platform-kit-sample/examples/common-platform-uikit) based on Compose Multiplatform by JetBrains, add support via UIKit, thus use the compose compiler and native iOS component.  

I've started to experiment with Compose Native, you can have a look at https://github.com/cl3m/kmp-redux/tree/skiko on iOS two views are SwiftUI and two views are Compose (ComposeSpaceView & ComposeCounterView) and share the same store. 

# Multiplatform Compose

A demo to show usage of Jetpack Compose in Android and iOS. Originally a Jetpack Compose implementation with native view and yoga.

## Table of contents

- [Requirements](#requirements)
- [Libraries](#libraries)
- [Demos](#demos)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [Sponsors](#sponsors)
- [License](#license)

## Requirements

- Android Studio
- Xcode
- cocoapods (gem install cocoapods)

## Libraries

- kotlinx coroutines
- kotlinx serialization
- ktor
- jetbrain compose (uikit experimental)
- [Precompose](https://github.com/Tlaster/PreCompose) (for navigation)

## Demos

Run the app to see a demo of compose on ios.

![Demos](https://github.com/cl3m/multiplatform-compose/blob/compose-jb/screenshots/Demos.png?raw=true)

#### AsyncImage

The image composable allow url loading

```kotlin
AsyncImage(url = "https://loremflickr.com/320/240/ocean", modifier = Modifier.preferredSize(200.dp))
```

#### SafeArea

SafeArea.current context with PaddingValues.


## Troubleshooting

### e: java.lang.IllegalStateException: No file for ***

Compose function and context has to be internal and not exposed to iOS module.

## Sponsors

No one yet, be the first [sponsor](https://github.com/sponsors/cl3m)!

## Contributing

All development (both new features and bug fixes) is performed in the `develop` branch. This way `master` always contains the sources of the most recently released version. Use git-flow if possible.

You can start a PR with incomplete implementation to shows what you are working on. Please send PRs with bug fixes or new features to the `develop` branch. Documentation fixes in the markdown files are an exception to this rule. They are updated directly in `master`.

The `develop` branch is pushed to `master` on release.

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
