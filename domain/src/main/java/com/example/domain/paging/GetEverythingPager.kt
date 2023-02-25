package com.example.domain.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.model.ArticleDomain
import com.example.domain.model.NewsDomainModel
import com.example.domain.repository.NewRepository

class GetEverythingPager constructor(
    private val repository: NewRepository,
    private val query: String,
): PagingSource<Int, ArticleDomain>() {

    override fun getRefreshKey(state: PagingState<Int, ArticleDomain>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleDomain> {
        val page = params.key ?: 1

        return try {
            val data = repository.getEverything(query = query, page = page)
            toLoadResult(data, page)
        } catch(e: Exception) {
            LoadResult.Error(e)
        }

    }

    private fun toLoadResult(data: NewsDomainModel, position: Int): LoadResult<Int, ArticleDomain> {
        return LoadResult.Page(
            data = data.articles,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (data.articles.isEmpty()) null else position + 1
        )
    }
}