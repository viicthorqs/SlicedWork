package com.slicedwork.slicedwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.slicedwork.slicedwork.ui.theme.SlicedWorkTheme

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
    Scaffold(
        modifier = Modifier.fillMaxSize(), topBar = {
            SlicedWorkTopBar(modifier = Modifier)
        },
        content = { innerPadding ->
            SlicedWorkContent(modifier = Modifier.padding(innerPadding))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SlicedWorkTopBar(modifier: Modifier) {
    TopAppBar(
        title = {
            Text(text = "SlicedWork!", modifier = modifier)
        },
        modifier = modifier
    )
}

@Composable
fun SlicedWorkContent(modifier: Modifier = Modifier) {
    Text(
        text = "Hello this is SlicedWork!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SlicedWorkAppPreview() {
    SlicedWorkTheme(darkTheme = false) {
        SlicedWorkApp()
    }
}

@Preview(showBackground = true)
@Composable
fun SlicedWorkAppDarkPreview() {
    SlicedWorkTheme(darkTheme = true) {
        SlicedWorkApp()
    }
}