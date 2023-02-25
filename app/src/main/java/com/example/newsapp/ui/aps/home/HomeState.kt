package com.example.newsapp.ui.aps.home

import androidx.paging.PagingData
import com.example.domain.model.ArticleDomain
import com.example.domain.model.NewsDomainModel
import com.example.newsapp.utils.LoadState

data class HomeState(
    var loadState: LoadState = LoadState.SUCCESS,
    var successState: PagingData<ArticleDomain>? = null
)