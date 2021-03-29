package com.lloyd.weather.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@JsonClass(generateAdapter = true)
@Parcelize
data class Weather(

    @Json(name = "id") val id: Int = 0,
    @Json(name = "main") val main: String = "",
    @Json(name = "description") val description: String = "",
    @Json(name = "icon") val icon: String = ""
) : Serializable, Parcelable