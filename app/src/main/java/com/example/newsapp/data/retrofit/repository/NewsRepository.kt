package com.example.newsapp.data.retrofit.repository

import com.example.newsapp.data.model.NewsModel
import com.example.newsapp.data.retrofit.api.RetrofitInstance
import com.example.newsapp.utils.KEY
import retrofit2.Response

class NewsRepository {
    suspend fun getEverything(query: String): Response<NewsModel> {
        return RetrofitInstance.api.getEverything(query = query, key = KEY)
    }

    suspend fun getTopHeadlines(country: String, category: String): Response<NewsModel> {
        return RetrofitInstance.api.getTopHeadLines(country = country, category = category, key = KEY)
    }

}