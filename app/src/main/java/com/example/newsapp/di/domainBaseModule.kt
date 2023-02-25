package com.example.newsapp.di

import com.example.domain.repository.LocalRepository
import com.example.domain.repository.NewRepository
import com.example.domain.userCase.*
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
    fun provideGetTopHeadLines(repository: NewRepository) = GetTopHeadLines(repository)

    @Singleton
    @Provides
    fun provideGetEvetrhing(repository: NewRepository) = GetEverythingCase(repository)

    @Singleton
    @Provides
    fun provideAddLocalFavCatCase(repository: LocalRepository) = AddLocalFavCatCase(repository)

    @Singleton
    @Provides
    fun provideReadLocalFavCatCase(repository: LocalRepository) = ReadLocalFavCatCase(repository)

    @Singleton
    @Provides
    fun provideGetSizeLocalFavCatCase(repository: LocalRepository) =
        GetSizeLocalFavCatCase(repository)

    @Singleton
    @Provides
    fun provideDeleteLocalFavCatCasee(repository: LocalRepository) =
        DeleteLocalFavCatCase(repository)

    @Singleton
    @Provides
    fun provideGetTopHeadlinesPagerCase(repository: NewRepository) =
        GetTopHeadlinesPagerCase(repository)

    @Singleton
    @Provides
    fun provideGetEverythingPagerCase(repository: NewRepository) =
        GetEverythingPagerCase(repository)


    @Provides
    fun provideNewsUserCase(
        getTopHeadLines: GetTopHeadLines,
        getEverythingCase: GetEverythingCase,
        addLocalFavCatCase: AddLocalFavCatCase,
        readLocalFavCatCase: ReadLocalFavCatCase,
        getSizeLocalFavCatCase: GetSizeLocalFavCatCase,
        deleteLocalFavCatCase: DeleteLocalFavCatCase,
        getTopHeadlinesPagerCase: GetTopHeadlinesPagerCase,
        getEverythingPagerCase: GetEverythingPagerCase,
    ) = com.example.domain.NewsUserCase(
        getTopHeadLines,
        getEverythingCase,
        addLocalFavCatCase,
        readLocalFavCatCase,
        getSizeLocalFavCatCase,
        deleteLocalFavCatCase,
        getTopHeadlinesPagerCase,
        getEverythingPagerCase
    )
}
