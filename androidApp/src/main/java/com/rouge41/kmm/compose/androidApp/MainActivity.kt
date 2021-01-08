package com.rouge41.kmm.compose.androidApp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import com.rouge41.kmm.compose.test.Content
import com.rouge41.kmm.compose.test.Resources

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //has to be set in code or in theme
        window.decorView.setBackgroundColor(Color.WHITE)
        window.statusBarColor = Color.parseColor("#3700B3")
        //window.statusBarColor = Color.WHITE
        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val cv: ComposeView = findViewById(R.id.compose_view)
        val resources = Resources(logo = R.drawable.logo)

        cv.setContent {
            Content(resources)
        }
    }
}
