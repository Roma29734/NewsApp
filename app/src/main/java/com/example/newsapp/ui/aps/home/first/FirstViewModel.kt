package com.example.newsapp.ui.aps.home.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.NewsUserCase
import com.example.newsapp.ui.aps.home.HomeState
import com.example.newsapp.utils.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val newsUserCase: NewsUserCase,
) : ViewModel() {

    private var _news = MutableStateFlow(HomeState())
    val news get() = _news


    fun getNews() {
        viewModelScope.launch (Dispatchers.IO) {
            _news.update { it.copy(loadState = LoadState.LOADING) }
            newsUserCase.getTopHeadlinesPagerCase(
                "us",
                newsUserCase.readLocalFavCatCase()[0].nameCat
//            "sports"
            ).collect { result ->
                _news.update { it.copy(loadState = LoadState.SUCCESS, successState = result) }
            }
        }
    }
}