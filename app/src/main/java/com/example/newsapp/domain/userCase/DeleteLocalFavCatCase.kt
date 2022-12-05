package com.example.newsapp.domain.userCase

import com.example.newsapp.data.local.repository.LocalRepository
import com.example.newsapp.data.model.localFav.FavModel
import javax.inject.Inject

class DeleteLocalFavCatCase @Inject constructor(private val repository: LocalRepository) {
    suspend operator fun invoke(model: List<FavModel>) = repository.deleteDb(model)
}