package com.example.newsapp.ui.aps.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.firebase.AuthenticationRepository
import com.example.data.model.localFav.FavEntity
import com.example.domain.NewsUserCase
import com.example.domain.model.FavModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: AuthenticationRepository,
    private val newsUserCase: com.example.domain.NewsUserCase,
): ViewModel() {

    val user = repository.currentUser

    private val _favCat: MutableLiveData<List<FavModel>> = MutableLiveData()
    val favCat get() = _favCat

    fun exit() {
        viewModelScope.launch {
            repository.logOut()
            delete()
        }
    }

    fun getFavCat() {
        viewModelScope.launch {
            _favCat.value = newsUserCase.readLocalFavCatCase()
        }
    }

    fun delete() {

        viewModelScope.launch {
            newsUserCase.deleteLocalFavCatCase()
        }
    }
}