package com.example.newsapp.ui.authentication.login

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.firebase.AuthenticationRepository
import com.example.newsapp.data.firebase.Resours
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthenticationRepository
) : ViewModel() {

    private val _state = MutableLiveData<Resours<FirebaseUser>?>(null)
    val state: MutableLiveData<Resours<FirebaseUser>?> = _state

    fun singIn(email: String, password: String) = viewModelScope.launch {
        _state.value = Resours.Loading
        if(inputCheck(email, password)) {
            val result = repository.singUser(email, password)
            _state.value = result
        } else {
            _state.value = Resours.Failure("Пустые поля")
        }
    }


    private fun inputCheck (title: String, subTitle: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(subTitle))
    }

}