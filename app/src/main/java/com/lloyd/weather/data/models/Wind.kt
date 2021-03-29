package com.lloyd.weather.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Wind (

	@Json(name= "speed") val speed : Double = 0.0,
	@Json(name= "deg") val deg : Int = 0
) : Parcelable