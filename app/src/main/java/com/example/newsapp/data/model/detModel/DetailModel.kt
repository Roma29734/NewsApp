package com.example.newsapp.data.model.detModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailModel(
    val url: String,
): Parcelable