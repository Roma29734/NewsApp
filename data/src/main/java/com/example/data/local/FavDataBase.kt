package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.localFav.FavEntity


@Database(entities = [FavEntity::class], version = 1, exportSchema = false)
abstract class FavDataBase: RoomDatabase() {
    abstract fun favDao() : FavDao
}