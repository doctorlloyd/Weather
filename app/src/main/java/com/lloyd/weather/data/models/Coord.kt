package com.lloyd.weather.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Coord (

	@Json(name = "lon") val lon : Double = 0.0,
	@Json(name ="lat") val lat : Double = 0.0
) : Parcelable