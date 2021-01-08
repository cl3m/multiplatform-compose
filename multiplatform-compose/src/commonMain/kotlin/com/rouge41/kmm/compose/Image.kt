package com.rouge41.kmm.compose

/*
    Currently the image comes from the app bundle in ios and android.
    It should certainly be in the android module and be in the pod

    check
    https://github.com/icerockdev/moko-resources
    https://github.com/haifengkao/PodAsset
 */

expect class ImageResource

@Composable
expect inline fun Image(resourceId: ImageResource, modifier: Modifier)
