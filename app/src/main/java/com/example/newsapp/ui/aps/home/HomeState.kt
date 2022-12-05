package com.example.newsapp.ui.aps.home

import com.example.newsapp.data.model.NewsModel
import com.example.newsapp.utils.LoadState

data class HomeState(
    var loadState: LoadState = LoadState.SUCCESS,
    var successState: NewsModel? = null
)