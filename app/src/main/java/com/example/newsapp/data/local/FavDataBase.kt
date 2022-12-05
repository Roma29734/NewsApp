package com.example.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapp.data.model.localFav.FavModel


@Database(entities = [FavModel::class], version = 1, exportSchema = false)
abstract class FavDataBase: RoomDatabase() {
    abstract fun favDao() : FavDao
}