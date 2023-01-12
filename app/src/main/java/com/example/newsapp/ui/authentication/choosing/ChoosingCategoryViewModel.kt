package com.example.newsapp.ui.authentication.choosing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.localFav.FavEntity
import com.example.domain.NewsUserCase
import com.example.domain.model.FavModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChoosingCategoryViewModel @Inject constructor(
    private val newsUserCase: NewsUserCase,
): ViewModel() {

    private var _addedList = mutableListOf<String>()
    val addedList get() = _addedList

    fun addCat(name: String) {
        _addedList.add(name)
    }

    fun deleteCat(name: String) {
        _addedList.remove(name)
    }

    fun addToDataBase(callBack: () -> Unit) {
        viewModelScope.launch {
            newsUserCase.addLocalFavCatCase(FavModel(0, _addedList[0]))
            newsUserCase.addLocalFavCatCase(FavModel(0, _addedList[1]))
            newsUserCase.addLocalFavCatCase(FavModel(0, _addedList[2]))
            callBack()
        }
    }
}