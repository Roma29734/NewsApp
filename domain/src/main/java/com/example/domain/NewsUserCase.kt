package com.example.domain

import com.example.domain.userCase.*

data class NewsUserCase (
    val getTopHeadLines: GetTopHeadLines,
    val getEverythingCase: GetEverythingCase,
    val addLocalFavCatCase: AddLocalFavCatCase,
    val readLocalFavCatCase: ReadLocalFavCatCase,
    val getSizeLocalFavCatCase: GetSizeLocalFavCatCase,
    val deleteLocalFavCatCase: DeleteLocalFavCatCase,
)