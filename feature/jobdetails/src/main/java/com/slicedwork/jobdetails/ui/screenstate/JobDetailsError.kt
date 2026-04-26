package com.slicedwork.jobdetails.ui.screenstate

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.slicedwork.designsystem.components.feedback.ErrorState
import com.slicedwork.designsystem.theme.SlicedWorkTheme

@Composable
fun JobDetailsError(errorMessage: String, modifier: Modifier = Modifier) {
    ErrorState(
        message = errorMessage,
        modifier = modifier,
    )
}

private const val PreviewJobDetailsErrorSampleMessage =
    "Falha na rede: tempo esgotado ao contatar o servidor."

@Composable
private fun JobDetailsErrorPreviewSurface(darkTheme: Boolean) {
    SlicedWorkTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            JobDetailsError(
                errorMessage = PreviewJobDetailsErrorSampleMessage,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@Preview(name = "Job Details Error Light")
@Composable
private fun JobDetailsErrorLightPreview() = JobDetailsErrorPreviewSurface(darkTheme = false)

@Preview(name = "Job Details Error Dark")
@Composable
private fun JobDetailsErrorDarkPreview() = JobDetailsErrorPreviewSurface(darkTheme = true)