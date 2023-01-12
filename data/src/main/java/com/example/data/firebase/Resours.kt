package com.example.data.firebase


sealed class Resours<out R> {
    data class Success<out R>(val result: R): Resours<R>()
    data class Failure(val exception: String): Resours<Nothing>()
    object Loading: Resours<Nothing>()
}