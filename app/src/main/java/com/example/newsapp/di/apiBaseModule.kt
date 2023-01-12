package com.example.newsapp.di

import com.example.data.retrofit.repository.NewsRepositoryImpl
import com.example.domain.repository.NewRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class apiBaseModule {

    @Provides
    fun provideNewsRepository(impl : NewsRepositoryImpl): NewRepository = impl

    @Provides
    fun provideNewsRepositoryImpl(): NewsRepositoryImpl = NewsRepositoryImpl()
}