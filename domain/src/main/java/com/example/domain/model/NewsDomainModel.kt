package com.example.domain.model

data class NewsDomainModel(
    val articles: List<ArticleDomain>,
    val status: String,
    val totalResults: Int
)