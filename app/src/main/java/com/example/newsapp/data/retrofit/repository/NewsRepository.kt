package com.example.newsapp.data.retrofit.repository

import com.example.newsapp.data.model.NewsModel
import com.example.newsapp.data.retrofit.api.RetrofitInstance
import com.example.newsapp.utils.KEY
import retrofit2.Response

class NewsRepository {
    suspend fun getTopHeadlines(country: String): Response<NewsModel> {
        return RetrofitInstance.api.getTopHeadlines(contry = "Ukrain", key = "3357336b9b2e429ba7060baea463559d")
    }
}