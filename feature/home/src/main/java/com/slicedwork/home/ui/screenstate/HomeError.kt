package com.slicedwork.home.ui.screenstate

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.slicedwork.designsystem.components.feedback.ErrorState
import com.slicedwork.designsystem.theme.SlicedWorkTheme

@Composable
fun HomeError(message: String, modifier: Modifier = Modifier) {
    ErrorState(
        message = message,
        modifier = modifier,
    )
}

private const val PreviewHomeErrorSampleMessage =
    "Falha na rede: tempo esgotado ao contatar o servidor."

@Composable
private fun HomeErrorPreviewSurface(darkTheme: Boolean) {
    SlicedWorkTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            HomeError(
                message = PreviewHomeErrorSampleMessage,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@Preview(name = "Error Light")
@Composable
private fun PreviewHomeErrorLight() = HomeErrorPreviewSurface(darkTheme = false)

@Preview(name = "Error Dark")
@Composable
private fun PreviewHomeErrorDark() = HomeErrorPreviewSurface(darkTheme = true)
