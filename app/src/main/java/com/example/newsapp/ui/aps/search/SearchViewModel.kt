package com.example.newsapp.ui.aps.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.NewsModel
import com.example.newsapp.data.retrofit.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel() {

    private var _searchResult: MutableLiveData<Response<NewsModel>> = MutableLiveData()
    val searchResult get() = _searchResult

    fun searchNews(query: String) {
        viewModelScope.launch {
            Log.d("viewModelSearch","запрос $query")
            _searchResult.value = repository.getEverything(query)
        }
    }
}