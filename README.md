[![Kotlin Multiplatform](https://img.shields.io/static/v1?logo=Kotlin&&logoColor=3c94cf&label=&message=Kotlin%20Multiplatform&color=555)](https://kotlinlang.org/docs/reference/multiplatform.html)

# Multiplatform Compose

A Kotlin library to use Jetpack Compose in Android and iOS. Allow to write UI for both in Kotin. Still experimental as many compose features are not yet available.

## Table of contents

- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Known issues](#known-issues)
- [Troubleshooting](#troubleshooting)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)

## Requirements

- Android Studio Canary
- cocoapods (gem install cocoapods)
- cocoapods-generate (gem install cocoapods-generate)

## Installation

The library is not yet published to Maven Central as it is still experimental.

## Usage

The simpliest code is :

```kotlin
@Composable
fun Content(resources: Resources) {
    Text("Hello world!")
}
```

A better start would be :

```kotlin
@Composable
fun Content(resources: Resources) {
    HelloPlatform()
}

@Composable
fun HelloPlatform() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Hello, ${Platform().platform}!")
    }
}
```
<img src="https://github.com/cl3m/multiplatform-compose/blob/develop/screenshots/HelloPlatform.png?raw=true" height="620">

More advance sample are in the test library.

### iOS Composables

#### HumanAppearance

Allow iOS styling such as font or global tintColor. 

```kotlin
HumanAppearance(tintColor: Color, backgroundColor: Color?, style: TextStyle) {
    // ...
}
```

#### SafeArea

Add safe area insets to the view, works in root, TabView and NavigationView

```kotlin
SafeArea {
    // ...
}
```

![Safe Area Screenshot](https://github.com/cl3m/multiplatform-compose/blob/develop/screenshots/Layout.png?raw=true)
*Layout without the safe area, with the safe area and on android*

#### TabView

UITabBarController for Compose

```kotlin
TabView {
    Tab(title = "First", image = UIImage.systemImageNamed("a.circle.fill")) {
      // ...
    }
    Tab(title = "Second", image = UIImage.systemImageNamed("a.circle.fill")) {
      // ...
    }
}
```

#### NavigationView

UINavigationController for Compose

```kotlin
NavigationView(startDestination = "first") { navController ->
    composable("first", title = "First") {
	SafeArea {
	    Button(onClick = { navController.navigate("second") }) { 
                // ...
            }
        }
    }
    composable("second", title = "Second") {
        SafeArea {
	    // ...
        }
    }
}
```

## Known issues

- Jetpack Compose require Android Studio Canary and an alpha build of Gradle. There is some workaround in _build.gradle.kts_ to make it work (testApi).
- Jetpack Compose is not supported in Kotlin Multiplatform Mobile library ([KT-38694](https://youtrack.jetbrains.com/issue/KT-38694)). Unfortunatly, the workaround mess with actual/expect function and prevent the use of expect function with default value. Thus functions are defined multiple time in the library. If you use an expect function with default value, you will get an error function not found or _java.lang.IllegalStateException: 2. expected value parameter count to be higher_.
- Android Studio does not autocomplete cocoapods imported library in iosMain. Thus it is in iosx64Main and symlinked to iosArm64Main.
- Images needs currently to be included in the android and ios resources separately.
- Navigation is currently not shared in the library
- Latest Android Studio Canary shows many undefined error but everthing compile fine. It was not the case before.

## Troubleshooting

### cinteropYogaKitIosArm64 FAILED YogaKit module not found

You did not read the requirements. Install cocoapods-generate "gem install cocoapods-generate", invalid cache and restat Android Studio

## Roadmap

- More Jetpack Compose feature support
- Better images/resources support
- UI Test with Github Actions
- Performance improvement/optimisation

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
