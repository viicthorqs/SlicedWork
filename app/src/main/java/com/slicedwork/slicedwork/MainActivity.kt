package com.slicedwork.slicedwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.slicedwork.designsystem.theme.SlicedWorkTheme
import com.slicedwork.slicedwork.ui.SlicedWorkApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlicedWorkTheme {
                SlicedWorkApp()
            }
        }
    }
}