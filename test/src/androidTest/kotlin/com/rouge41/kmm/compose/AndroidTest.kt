package com.rouge41.kmm.compose.test

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidTest {

    @Test
    fun platformShouldContainAndroid() {
        assertTrue("Check Android is mentioned", Platform().platform.contains("Android"))
    }
}
