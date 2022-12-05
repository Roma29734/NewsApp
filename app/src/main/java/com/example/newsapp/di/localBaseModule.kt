package com.example.newsapp.di

import android.content.Context
import androidx.room.Room
import com.example.newsapp.data.local.FavDao
import com.example.newsapp.data.local.FavDataBase
import com.example.newsapp.data.local.repository.LocalRepository
import com.example.newsapp.data.local.repository.LocalRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class localBaseModule {

    @Provides
    fun provideRepository(impl: LocalRepositoryImpl): LocalRepository = impl

    @Provides
    fun provideFavDao(appDataBase: FavDataBase): FavDao = appDataBase.favDao()

    @Provides
    @Singleton
    fun provideFavDatabase(@ApplicationContext appContext: Context): FavDataBase =
        Room.databaseBuilder(
            appContext,
            FavDataBase::class.java,
            "fav_table"
        ).build()
}