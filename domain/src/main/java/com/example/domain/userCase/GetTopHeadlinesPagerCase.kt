package com.example.domain.userCase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.domain.model.ArticleDomain
import com.example.domain.paging.GetTopHeadlinesPager
import com.example.domain.repository.NewRepository
import kotlinx.coroutines.flow.Flow

class GetTopHeadlinesPagerCase constructor(private val repository: NewRepository) {

    suspend operator fun invoke(
        country: String,
        category: String,
    ): Flow<PagingData<ArticleDomain>> {
        return Pager(
            config = PagingConfig(
                pageSize = 2,
                enablePlaceholders = false,
                maxSize = 50,
                prefetchDistance = 5,
                initialLoadSize = 20
            )
        ) {
            GetTopHeadlinesPager(category = category, country = country, repository = repository)
        }.flow

    }
}