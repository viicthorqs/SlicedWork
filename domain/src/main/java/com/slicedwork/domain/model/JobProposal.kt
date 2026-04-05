package com.slicedwork.domain.model

data class JobProposal(
    val id: String,
    val jobId: String,
    val workerId: String,
    val status: JobProposalStatus,
    val createdAt: String?,
)
