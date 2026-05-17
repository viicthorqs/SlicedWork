package com.slicedwork.joblist.ui.screenstate

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.slicedwork.designsystem.components.feedback.ErrorState
import com.slicedwork.designsystem.theme.SlicedWorkTheme

@Composable
fun JobListError(message: String, modifier: Modifier = Modifier) {
    ErrorState(message = message, modifier = modifier,)
}

private const val PreviewJobListErrorSampleMessage =
    "Falha na rede: tempo esgotado ao contatar o servidor."

@Composable
private fun JobListErrorPreviewSurface(darkTheme: Boolean) {
    SlicedWorkTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            JobListError(
                message = PreviewJobListErrorSampleMessage,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@Preview(name = "JobList Error Light")
@Composable
private fun PreviewJobListErrorLight() = JobListErrorPreviewSurface(darkTheme = false)

@Preview(name = "JobList Error Dark")
@Composable
private fun PreviewJobListErrorDark() = JobListErrorPreviewSurface(darkTheme = true)
