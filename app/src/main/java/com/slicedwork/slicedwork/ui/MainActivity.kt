package com.slicedwork.slicedwork.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.slicedwork.designsystem.theme.SlicedWorkTheme
import com.slicedwork.home.ui.HomeScreen

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

@Composable
fun SlicedWorkApp() {
    HomeScreen()
}
