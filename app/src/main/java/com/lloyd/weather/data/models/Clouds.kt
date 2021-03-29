package com.lloyd.weather.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Clouds (

	@Json(name = "all") val all : Int = 0
) : Parcelable