package com.slicedwork.slicedwork.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.slicedwork.slicedwork.SlicedWorkRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SlicedWorkTopBar(
    currentRoute: SlicedWorkRoute?,
    canNavigateBack: Boolean,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = when (currentRoute) {
                    SlicedWorkRoute.Home -> "SlicedWork"
                    is SlicedWorkRoute.JobDetails -> "Detalhes do bico"
                    null -> ""
                }
            )
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar"
                    )
                }
            }
        }
    )
}