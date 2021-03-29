package com.lloyd.weather.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Sys (

	@Json(name = "country") val country : String = "",
	@Json(name = "sunrise") val sunrise : Int = 0,
	@Json(name = "sunset") val sunset : Int = 0
) : Parcelable