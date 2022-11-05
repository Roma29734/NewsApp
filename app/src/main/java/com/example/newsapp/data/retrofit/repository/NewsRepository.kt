package com.example.newsapp.data.retrofit.repository

import com.example.newsapp.data.model.NewsModel
import com.example.newsapp.data.retrofit.api.RetrofitInstance
import retrofit2.Response

class NewsRepository {
    suspend fun getTopHeadlines(country: String, key: String): Response<NewsModel> {
        return RetrofitInstance.api.getTopHeadlines(contry = country, key = key)
    }
}