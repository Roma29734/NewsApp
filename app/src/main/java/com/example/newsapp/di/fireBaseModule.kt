package com.example.newsapp.di

import com.example.data.firebase.AuthenticationRepository
import com.example.data.firebase.AuthenticationRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class fireBaseModule {

    @Provides
    fun providesFireBaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun providesAuthenticationRepository(impl: AuthenticationRepositoryImpl): AuthenticationRepository =
        impl

    @Provides
    fun provideAuthenticationRepositoryImpl(firebaseAuth: FirebaseAuth): AuthenticationRepositoryImpl =
        AuthenticationRepositoryImpl(firebaseAuth)

    @Provides
    fun provideCurrentUser(repository: AuthenticationRepository): FirebaseUser? =
        repository.currentUser
}