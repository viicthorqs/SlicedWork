package com.slicedwork.domain.model

data class JobAddress(
    val country: String,
    val state: String,
    val city: String,
    val neighborhood: String,
    val postalCode: String,
    val street: String,
    val number: String,
    val complement: String?,
)
