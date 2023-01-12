package com.example.domain.repository

import com.example.domain.model.NewsDomainModel

interface NewRepository {
    suspend fun getEverything(query: String): NewsDomainModel

    suspend fun getTopHeadlines(country: String, category: String): NewsDomainModel
}