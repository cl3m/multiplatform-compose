package com.rouge41.kmm.compose.test

import kotlin.test.Test
import kotlin.test.assertTrue

class IosTest {

    @Test
    fun platformShouldContainIOS() {
        assertTrue(Platform().platform.contains("iOS"), "Check iOS is mentioned")
    }
}
