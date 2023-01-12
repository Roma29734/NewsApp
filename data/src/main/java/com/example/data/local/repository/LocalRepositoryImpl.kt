package com.example.data.local.repository

import com.example.data.local.FavDao
import com.example.data.model.localFav.FavEntity
import com.example.data.toData
import com.example.data.toDomain
import com.example.domain.model.FavModel
import com.example.domain.repository.LocalRepository

class LocalRepositoryImpl constructor(
    private val dao: FavDao
): LocalRepository {

    override suspend fun addFav(favModel: FavModel) {
        dao.addFav(favModel.toData())
    }

    override suspend fun readFavCat(): List<FavModel> {
        return dao.readFavCat().map { it.toDomain() }
    }

    override suspend fun getSizeTable(): Int {
        return dao.getSizeTable()
    }

    override suspend fun deleteDb() {
        dao.deleteTableFav()
    }
}