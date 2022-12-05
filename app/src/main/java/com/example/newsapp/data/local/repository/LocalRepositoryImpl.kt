package com.example.newsapp.data.local.repository

import com.example.newsapp.data.local.FavDao
import com.example.newsapp.data.model.localFav.FavModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val dao: FavDao
): LocalRepository {
    override suspend fun addFav(favModel: FavModel) {
        dao.addFav(favModel)
    }

    override suspend fun readFavCat(): List<FavModel> {
        return dao.readFavCat()
    }

    override suspend fun getSizeTable(): Int {
        return dao.getSizeTable()
    }

    override suspend fun deleteDb(model: List<FavModel>) {
        dao.deleteTable(model)
    }
}