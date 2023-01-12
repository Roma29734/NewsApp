package com.example.domain.userCase


import com.example.domain.repository.LocalRepository


class DeleteLocalFavCatCase  constructor(private val repository: LocalRepository) {
    suspend operator fun invoke() = repository.deleteDb()
}