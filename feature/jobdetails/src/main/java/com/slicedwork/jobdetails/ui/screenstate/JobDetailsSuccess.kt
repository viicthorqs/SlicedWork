package com.slicedwork.jobdetails.ui.screenstate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slicedwork.designsystem.ext.asCurrency
import com.slicedwork.designsystem.ext.toPainterResource
import com.slicedwork.designsystem.ext.toStringResource
import com.slicedwork.designsystem.theme.SlicedWorkTheme
import com.slicedwork.domain.model.Job
import com.slicedwork.jobdetails.R
import com.slicedwork.jobdetails.ui.preview.JobDetailsPreviewData

@Composable
fun JobDetailsSuccess(job: Job, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        JobDetailsHeader(job = job)

        JobDetailsSection(title = stringResource(R.string.job_details_description)) {
            Text(
                text = job.description,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        JobDetailsSection(title = stringResource(R.string.job_details_location)) {
            Text(
                text = "${job.address.neighborhood}, ${job.address.city}",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        JobDetailsSection(title = stringResource(R.string.job_details_category)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    painter = painterResource(job.category.toPainterResource()),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp)
                )

                Text(
                    text = stringResource(job.category.toStringResource()),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
private fun JobDetailsHeader(
    job: Job,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = job.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = job.price.asCurrency(),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun JobDetailsSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                content = content
            )
        }
    }
}

@Composable
private fun JobDetailsSuccessPreviewSurface(darkTheme: Boolean) {
    SlicedWorkTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            JobDetailsSuccess(
                job = JobDetailsPreviewData.job,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(name = "Job Details Success Light")
@Composable
private fun JobDetailsSuccessLightPreview() = JobDetailsSuccessPreviewSurface(darkTheme = false)

@Preview(name = "Job Details Success Dark")
@Composable
private fun JobDetailsSuccessDarkPreview() = JobDetailsSuccessPreviewSurface(darkTheme = true)
