package com.example.domain.userCase


import com.example.domain.repository.LocalRepository


class ReadLocalFavCatCase  constructor(private val repository: LocalRepository){
    suspend operator fun invoke() = repository.readFavCat()
}