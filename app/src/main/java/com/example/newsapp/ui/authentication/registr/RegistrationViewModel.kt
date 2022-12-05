package com.example.newsapp.ui.authentication.registr

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.firebase.AuthenticationRepository
import com.example.newsapp.data.firebase.Resours
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: AuthenticationRepository,
): ViewModel() {
    private val _state = MutableLiveData<Resours<FirebaseUser>?>(null)
    val state: MutableLiveData<Resours<FirebaseUser>?> = _state

    fun registrIn(name: String,email: String, password: String) = viewModelScope.launch {
        _state.value = Resours.Loading
        if(inputCheck(name, email, password)) {
            val result = repository.createUser(name, email, password)
            _state.value = result
        } else {
            _state.value = Resours.Failure("Пустые поля")
        }
    }

    private fun inputCheck (title: String, subTitle: String, thirtTitle: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(subTitle) && TextUtils.isEmpty(thirtTitle))
    }
}