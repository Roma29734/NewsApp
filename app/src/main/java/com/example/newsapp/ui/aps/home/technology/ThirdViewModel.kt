package com.example.newsapp.ui.aps.home.technology

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.NewsModel
import com.example.newsapp.data.retrofit.repository.NewsRepository
import com.example.newsapp.domain.NewsUserCase
import com.example.newsapp.ui.aps.home.HomeState
import com.example.newsapp.utils.LoadState
import com.example.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ThirdViewModel @Inject constructor(
    private val newsUserCase: NewsUserCase,
): ViewModel() {
    private var _news = MutableStateFlow(HomeState())
    val news get() = _news

    fun getNews() {
        viewModelScope.launch {
//            _news.value = repository.getTopHeadlines("us", "sports")
            newsUserCase.getTopHeadLines("us", newsUserCase.readLocalFavCatCase()[2].nameCat).collect {result ->
                when(result) {
                    is Resource.Loading -> {
                        _news.update { it.copy(loadState = LoadState.LOADING) }
                    }
                    is Resource.Error -> {
                        _news.update { it.copy(loadState = LoadState.ERROR) }
                    }
                    is Resource.Success -> {
                        _news.update { it.copy(successState = result.data, loadState = LoadState.SUCCESS) }
                    }
                }
            }
        }
    }
}