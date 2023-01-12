package com.example.data.retrofit.api


import com.example.domain.model.NewsDomainModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    //https://newsapi.org/v2/everything?q=Ukrain&apiKey=3357336b9b2e429ba7060baea463559d
//    https://newsapi.org/v2/top-headlines?country=us&apiKey=3357336b9b2e429ba7060baea463559d
//https://newsapi.org/v2/everything?q=Ukrain&apiKey=3357336b9b2e429ba7060baea463559d
    @GET("v2/everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("apiKey") key: String
    ): NewsDomainModel

    @GET("v2/top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") key: String,
    ): NewsDomainModel
}