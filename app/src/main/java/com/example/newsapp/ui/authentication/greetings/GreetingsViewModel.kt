package com.example.newsapp.ui.authentication.greetings

import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.NewsUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GreetingsViewModel @Inject constructor(
    private val newsUserCase: NewsUserCase,
): ViewModel() {

    suspend fun checkSize(): Boolean {
        return newsUserCase.getSizeLocalFavCatCase() != 0
    }
}