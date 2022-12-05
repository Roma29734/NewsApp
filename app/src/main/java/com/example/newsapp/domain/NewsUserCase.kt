package com.example.newsapp.domain

import com.example.newsapp.domain.userCase.*

data class NewsUserCase (
    val getTopHeadLines: GetTopHeadLines,
    val addLocalFavCatCase: AddLocalFavCatCase,
    val readLocalFavCatCase: ReadLocalFavCatCase,
    val getSizeLocalFavCatCase: GetSizeLocalFavCatCase,
    val deleteLocalFavCatCase: DeleteLocalFavCatCase,
)