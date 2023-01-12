package com.example.newsapp.ui.aps.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.NewsUserCase
import com.example.domain.utils.Resource
import com.example.newsapp.ui.aps.home.HomeState
import com.example.newsapp.utils.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUserCase: NewsUserCase
): ViewModel() {

    private var _searchResult = MutableStateFlow(HomeState())
    val searchResult get() = _searchResult

    fun searchNews(query: String) {
        viewModelScope.launch {
            newsUserCase.getEverythingCase(query).collect {result ->
                when(result) {
                    is Resource.Error -> {
                        _searchResult.update { it.copy(loadState = LoadState.ERROR) }
                    }
                    is Resource.Loading -> {
                        _searchResult.update { it.copy(loadState = LoadState.LOADING) }
                    }
                    is Resource.Success -> {
                        _searchResult.update { it.copy(successState = result.data, loadState = LoadState.SUCCESS) }
                    }
                }
            }
        }
    }
}