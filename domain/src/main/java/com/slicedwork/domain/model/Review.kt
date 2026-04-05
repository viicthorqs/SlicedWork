package com.slicedwork.domain.model

data class Review(
    val id: String,
    val jobId: String,
    val reviewerId: String,
    val reviewedUserId: String,
    val score: Int,
    val comments: List<String>?,
)
