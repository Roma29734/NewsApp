package com.example.domain.repository

import com.example.domain.model.FavModel

interface LocalRepository {

    suspend fun addFav(favEntity: FavModel)

    suspend fun readFavCat(): List<FavModel>

    suspend fun getSizeTable(): Int

    suspend fun deleteDb()
}