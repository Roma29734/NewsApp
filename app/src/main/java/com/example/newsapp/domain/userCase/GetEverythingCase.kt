package com.example.newsapp.domain.userCase

import com.example.newsapp.data.model.NewsModel
import com.example.newsapp.data.retrofit.repository.NewsRepository
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetEverythingCase @Inject constructor(private val repository: NewsRepository) {
     suspend operator fun invoke(query: String): Flow<Resource<NewsModel>> = flow {
         try {
             emit(Resource.Loading())
             val result = repository.getEverything(query)
             emit(Resource.Success(result))
         } catch (e: IOException) {
             emit(Resource.Error("No ithernet connect"))
         } catch (e: Exception) {
             emit(Resource.Error("Exception $e"))
         }
     }
}