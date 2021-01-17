package com.rouge41.kmm.compose

/*
    Currently the image comes from the app bundle in ios and android.
    It should certainly be in the android module and be in the pod

    check
    https://github.com/icerockdev/moko-resources
    https://github.com/haifengkao/PodAsset
 */

expect class ImageResource
expect interface ContentScale{
    companion object {
        val Fit: ContentScale
    }
}
@Composable
expect inline fun Image(resourceId: ImageResource,
                        modifier: Modifier = Modifier,
                        alignment: AlignmentVerticalAndHorizontal = Alignment.Center,
                        contentScale: ContentScale = ContentScale.Fit,
                        alpha: Float = 1.0f)

@Composable
expect inline fun Image(url: String, modifier: Modifier)