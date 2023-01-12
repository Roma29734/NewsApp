package com.example.newsapp.ui.aps.home

import androidx.lifecycle.ViewModel
import com.example.domain.NewsUserCase
import com.example.domain.model.FavModel
import dagger.hilt.android.lifecycle.HiltViewModel
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