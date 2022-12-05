package com.example.newsapp.domain.userCase

import com.example.newsapp.data.local.repository.LocalRepository
import javax.inject.Inject

class ReadLocalFavCatCase @Inject constructor(private val repository: LocalRepository){
    suspend operator fun invoke() = repository.readFavCat()
}