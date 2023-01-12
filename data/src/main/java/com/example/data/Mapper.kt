package com.example.data


import com.example.data.model.localFav.FavEntity
import com.example.domain.model.FavModel


fun FavEntity.toDomain() = FavModel(
    id = id,
    nameCat = nameCat
)

fun FavModel.toData() = FavEntity(
    id = id,
    nameCat = nameCat
)
