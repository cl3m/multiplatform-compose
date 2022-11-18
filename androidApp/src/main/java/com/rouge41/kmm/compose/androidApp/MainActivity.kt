package com.rouge41.kmm.compose.androidApp

import android.graphics.Color
import android.os.Bundle
import com.rouge41.kmm.compose.RootView
import moe.tlaster.precompose.lifecycle.PreComposeActivity
import moe.tlaster.precompose.lifecycle.setContent

class MainActivity : PreComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // has to be set in code or in theme
        window.decorView.setBackgroundColor(Color.WHITE)
        window.statusBarColor = Color.parseColor("#cc7000")

        setContent {
            RootView()
        }
    }
}
