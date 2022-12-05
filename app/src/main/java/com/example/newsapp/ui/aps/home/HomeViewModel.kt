package com.example.newsapp.ui.aps.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.NewsModel
import com.example.newsapp.data.model.localFav.FavModel
import com.example.newsapp.domain.NewsUserCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUserCase: NewsUserCase
): ViewModel() {


    suspend fun getName(): List<FavModel> {
        return newsUserCase.readLocalFavCatCase()
    }

    suspend fun checkSize(): Boolean {
        return newsUserCase.getSizeLocalFavCatCase() != 0
    }
}