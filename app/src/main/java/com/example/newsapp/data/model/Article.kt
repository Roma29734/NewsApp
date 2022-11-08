package com.example.newsapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)