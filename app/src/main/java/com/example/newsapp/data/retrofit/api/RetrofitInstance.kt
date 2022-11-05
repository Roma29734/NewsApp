package com.example.newsapp.data.retrofit.api

import com.example.newsapp.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: NewsService by lazy {
        retrofit.create(NewsService::class.java)
    }
}

