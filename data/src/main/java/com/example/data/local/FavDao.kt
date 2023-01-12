package com.example.data.local

import androidx.room.*
import com.example.data.model.localFav.FavEntity

@Dao
interface FavDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFav(favEntity: FavEntity)

    @Query("SELECT * FROM fav_table")
    suspend fun readFavCat(): List<FavEntity>

    @Query("SELECT COUNT(*) FROM fav_table")
    suspend fun getSizeTable(): Int

    @Query("DELETE FROM fav_table")
    suspend fun deleteTableFav()
}