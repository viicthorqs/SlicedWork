package com.slicedwork.home.ui.screenstate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slicedwork.designsystem.theme.SlicedWorkTheme
import com.slicedwork.domain.model.JobCategory
import com.slicedwork.home.ui.preview.HomePreviewData.jobCategories
import com.slicedwork.ui.toUi

@Composable
fun HomeSuccess(
    jobCategories: List<JobCategory>,
    gridColumns: Int,
    onJobCategoryClicked: (JobCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(gridColumns),
        verticalItemSpacing = 16.dp,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(jobCategories) { jobCategory ->
            JobCategoryItem(
                jobCategory = jobCategory,
                onClick = onJobCategoryClicked,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun JobCategoryItem(
    jobCategory: JobCategory,
    onClick: (JobCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    val jobCategoryUi = jobCategory.toUi()

    Card(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        onClick = { onClick(jobCategory) },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(jobCategoryUi.imageRes),
                contentDescription = stringResource(jobCategoryUi.stringRes),
                modifier = Modifier.size(56.dp),
                tint = MaterialTheme.colorScheme.primary,
            )

            Text(
                text = stringResource(jobCategoryUi.stringRes),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun HomeSuccessPreviewSurface(darkTheme: Boolean, gridColumns: Int) {
    SlicedWorkTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            HomeSuccess(
                jobCategories = jobCategories,
                gridColumns = gridColumns,
                onJobCategoryClicked = {},
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(name = "Home Success Light")
@Composable
private fun HomeSuccessLightPreview() = HomeSuccessPreviewSurface(
    darkTheme = false,
    gridColumns = 2
)

@Preview(name = "Home Success Dark")
@Composable
private fun HomeSuccessDarkPreview() = HomeSuccessPreviewSurface(
    darkTheme = true,
    gridColumns = 2
)

@Preview(name = "Wide Home Success Light", widthDp = 1000, heightDp = 600)
@Composable
private fun WideHomeSuccessLightPreview() = HomeSuccessPreviewSurface(
    darkTheme = false,
    gridColumns = 3
)

@Preview(name = "Wide Home Success Dark", widthDp = 1000, heightDp = 600)
@Composable
private fun WideHomeSuccessDarkPreview() = HomeSuccessPreviewSurface(
    darkTheme = true,
    gridColumns = 3
)
