package com.example.newsapp.ui.aps.home.third

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class ThirdViewModel @Inject constructor(
    private val newsUserCase: com.example.domain.NewsUserCase,
): ViewModel() {
    private var _news = MutableStateFlow(HomeState())
    val news get() = _news

    fun getNews() {
        viewModelScope.launch (Dispatchers.IO) {
            _news.update { it.copy(loadState = LoadState.LOADING) }
            newsUserCase.getTopHeadlinesPagerCase(
                "us",
                newsUserCase.readLocalFavCatCase()[2].nameCat
//            "sports"
            ).collect { result ->
                _news.update { it.copy(loadState = LoadState.SUCCESS, successState = result) }
            }
        }
    }
}