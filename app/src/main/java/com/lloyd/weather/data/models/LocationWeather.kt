package com.lloyd.weather.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class LocationWeather (

    @Json(name = "coord") val coord : Coord = Coord( 0.0,0.0,),
    @Json(name = "weather") val weather : List<Weather> = listOf(),
    @Json(name = "base") val base : String = "",
    @Json(name = "main") val main : Main = Main(),
    @Json(name = "visibility") val visibility : Int = 0,
    @Json(name = "wind") val wind : Wind = Wind(),
    @Json(name = "clouds") val clouds : Clouds = Clouds(),
    @Json(name = "dt") val dt : Int = 0,
    @Json(name = "sys") val sys : Sys = Sys(),
    @Json(name = "timezone") val timezone : Int= 0,
    @Json(name = "id") val id : Int = 0,
    @Json(name ="name") val name : String = "",
    @Json(name= "cod") val cod : Int=0
) : Parcelable