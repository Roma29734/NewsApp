package com.example.data.firebase

import com.google.firebase.auth.FirebaseUser


interface AuthenticationRepository {

    val currentUser: FirebaseUser?

    suspend fun createUser(name: String,email: String, password: String): Resours<FirebaseUser>

    suspend fun singUser( email: String, password: String): Resours<FirebaseUser>

    suspend fun logOut()
}