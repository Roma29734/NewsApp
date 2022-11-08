package com.example.newsapp.ui.aps.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.firebase.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: AuthenticationRepository,
): ViewModel() {

    val user = repository.currentUser

    fun exit() {
        viewModelScope.launch {
            repository.logOut()
        }
    }
}