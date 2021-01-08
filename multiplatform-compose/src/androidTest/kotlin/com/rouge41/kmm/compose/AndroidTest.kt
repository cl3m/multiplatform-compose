package com.rouge41.kmm.compose

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", Greeting().greeting().contains("Android"))
    }
}
