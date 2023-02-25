package com.example.data.retrofit.repository

import com.example.data.retrofit.api.RetrofitInstance
import com.example.data.utils.API_KEY
import com.example.domain.model.NewsDomainModel
import com.example.domain.repository.NewRepository

class NewsRepositoryImpl() : NewRepository {
    override suspend fun getEverything(query: String, page: Int): NewsDomainModel {
        return RetrofitInstance.api.getEverything(query = query, key = API_KEY, page = page)
    }

    override suspend fun getTopHeadlines(
        country: String,
        category: String,
        page: Int
    ): NewsDomainModel {
        return RetrofitInstance.api.getTopHeadLines(
            country = country,
            category = category,
            key = API_KEY,
            page = page,
        )
    }
}