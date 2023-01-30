package com.example.data.retrofit.api


import com.example.domain.model.NewsDomainModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("v2/everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("apiKey") key: String,
        @Query("page") page: Int
    ): NewsDomainModel

    @GET("v2/top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") key: String,
        @Query("page") page: Int
    ): NewsDomainModel
}