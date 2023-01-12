package com.example.domain.userCase

import com.example.domain.model.FavModel
import com.example.domain.repository.LocalRepository

class AddLocalFavCatCase  constructor(private val repository: LocalRepository) {
    suspend operator fun invoke(favEntity: FavModel) = repository.addFav(favEntity)
}