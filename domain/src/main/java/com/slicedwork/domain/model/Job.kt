package com.slicedwork.domain.model

data class Job(
    val id: String,
    val ownerId: String,
    val title: String,
    val description: String,
    val category: JobCategory,
    val address: JobAddress,
    val imageUrl: String?,
    val price: Double,
    val status: JobStatus,
)
