package com.example.newsapp.data.local.repository

import com.example.newsapp.data.model.localFav.FavModel
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    suspend fun addFav(favModel: FavModel)

    suspend fun readFavCat(): List<FavModel>

    suspend fun getSizeTable(): Int

    suspend fun deleteDb(model: List<FavModel>)
}