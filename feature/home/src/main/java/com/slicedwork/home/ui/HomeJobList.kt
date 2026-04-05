package com.slicedwork.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slicedwork.designsystem.ext.asCurrency
import com.slicedwork.designsystem.ext.painter
import com.slicedwork.designsystem.theme.SlicedWorkTheme
import com.slicedwork.domain.model.Job
import com.slicedwork.home.ui.preview.HomeJobPreviewData

@Composable
fun HomeJobList(jobs: List<Job>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(jobs) { job ->
            HomeJobCard(job, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun HomeJobCard(job: Job, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 16.dp, end = 16.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = job.category.painter(),
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                tint = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = job.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(4.dp))
                HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Text(
                        text = "${job.address.neighborhood}, ${job.address.city}",
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f),
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = job.price.asCurrency(),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        softWrap = false,
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeJobListPreviewSurface(darkTheme: Boolean) {
    SlicedWorkTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            HomeJobList(
                jobs = HomeJobPreviewData.jobs,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            )
        }
    }
}

@Preview(name = "Jobs List Light")
@Composable
private fun PreviewHomeJobListLight() = HomeJobListPreviewSurface(darkTheme = false)

@Preview(name = "Jobs List Dark")
@Composable
private fun PreviewHomeJobListDark() = HomeJobListPreviewSurface(darkTheme = true)
