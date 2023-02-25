package com.example.domain.repository

import com.example.domain.model.NewsDomainModel

interface NewRepository {
    suspend fun getEverything(query: String, page: Int): NewsDomainModel

    suspend fun getTopHeadlines(country: String, category: String, page: Int): NewsDomainModel
}