package com.example.newsapp.di

import com.example.newsapp.data.local.repository.LocalRepository
import com.example.newsapp.data.retrofit.repository.NewsRepository
import com.example.newsapp.domain.NewsUserCase
import com.example.newsapp.domain.userCase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class domainBaseModule {

    @Singleton
    @Provides
    fun provideGetTopHeadLines(repository: NewsRepository) = GetTopHeadLines(repository)

    @Singleton
    @Provides
    fun provideGetEvetrhing(repository: NewsRepository) = GetEverythingCase(repository)

    @Singleton
    @Provides
    fun provideAddLocalFavCatCase(repository: LocalRepository) = AddLocalFavCatCase(repository)

    @Singleton
    @Provides
    fun provideReadLocalFavCatCase(repository: LocalRepository) = ReadLocalFavCatCase(repository)

    @Singleton
    @Provides
    fun provideGetSizeLocalFavCatCase(repository: LocalRepository) = GetSizeLocalFavCatCase(repository)

    @Singleton
    @Provides
    fun provideDeleteLocalFavCatCasee(repository: LocalRepository) = DeleteLocalFavCatCase(repository)

    @Provides
    fun provideNewsUserCase (
        getTopHeadLines: GetTopHeadLines,
        getEverythingCase: GetEverythingCase,
        addLocalFavCatCase: AddLocalFavCatCase,
        readLocalFavCatCase: ReadLocalFavCatCase,
        getSizeLocalFavCatCase: GetSizeLocalFavCatCase,
        deleteLocalFavCatCase: DeleteLocalFavCatCase,
    ) = NewsUserCase(
        getTopHeadLines,
        getEverythingCase,
        addLocalFavCatCase,
        readLocalFavCatCase,
        getSizeLocalFavCatCase,
        deleteLocalFavCatCase
    )
}
