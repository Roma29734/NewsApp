package com.example.domain.userCase


import android.util.Log
import com.example.domain.model.NewsDomainModel
import com.example.domain.repository.NewRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import java.io.IOException


class GetEverythingCase  constructor(private val repository: NewRepository) {
     suspend operator fun invoke(query: String): Flow<Resource<NewsDomainModel>> = flow {
         try {
             emit(Resource.Loading())
             val result = repository.getEverything(query)
             Log.d("abobaAmebnaya", "$result")
             emit(Resource.Success(result))
         } catch (e: IOException) {
             emit(Resource.Error("No ithernet connect"))
             Log.d("abobaAmebnaya","$e")
         } catch (e: Exception) {
             emit(Resource.Error("Exception $e"))
             Log.d("abobaAmebnaya","$e")
         }
     }
}