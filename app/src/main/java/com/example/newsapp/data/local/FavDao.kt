package com.example.newsapp.data.local

import androidx.room.*
import com.example.newsapp.data.model.localFav.FavModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FavDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFav(favModel: FavModel)

    @Query("SELECT * FROM fav_table")
    suspend fun readFavCat(): List<FavModel>

    @Query("SELECT COUNT(*) FROM fav_table")
    suspend fun getSizeTable(): Int

    @Delete(entity = FavModel::class)
    suspend fun deleteTable(modelList: List<FavModel>)
}