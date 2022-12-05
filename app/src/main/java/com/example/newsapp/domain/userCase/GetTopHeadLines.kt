package com.example.newsapp.domain.userCase

import com.example.newsapp.data.model.NewsModel
import com.example.newsapp.data.retrofit.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetTopHeadLines @Inject constructor(
    private val repository: NewsRepository,
) {
    operator fun invoke(country: String, category: String): Flow<Resource<NewsModel>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getTopHeadlines(country, category)
            emit(Resource.Success(result))
        } catch (e: IOException) {
            emit(Resource.Error("No ithernet connect"))
        } catch (e: Exception) {
            emit(Resource.Error("Exception $e"))
        }
    }
}