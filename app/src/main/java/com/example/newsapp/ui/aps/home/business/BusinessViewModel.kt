package com.example.newsapp.ui.aps.home.business

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
class BusinessViewModel @Inject constructor(
    private val repository: NewsRepository,
): ViewModel() {

    private var _news: MutableLiveData<Response<NewsModel>> = MutableLiveData()
    val news get() = _news

    init {
        viewModelScope.launch {
             _news.value = repository.getTopHeadlines("us", "business")
        }
    }
}