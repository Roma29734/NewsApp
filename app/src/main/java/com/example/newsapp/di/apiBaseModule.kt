package com.example.newsapp.di

import com.example.newsapp.data.retrofit.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class apiBaseModule {

    @Provides
    fun provideNewsRepository(): NewsRepository = NewsRepository()
}