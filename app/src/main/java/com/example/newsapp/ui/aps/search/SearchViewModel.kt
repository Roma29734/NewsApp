package com.example.newsapp.ui.aps.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.NewsUserCase
import com.example.domain.utils.Resource
import com.example.newsapp.ui.aps.home.HomeState
import com.example.newsapp.utils.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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
        viewModelScope.launch (Dispatchers.IO) {
            _searchResult.update { it.copy(loadState = LoadState.LOADING) }
            newsUserCase.getEverythingPagerCase(query).collect {result ->
                _searchResult.update { it.copy(loadState = LoadState.SUCCESS, successState = result) }
            }
        }
    }
}