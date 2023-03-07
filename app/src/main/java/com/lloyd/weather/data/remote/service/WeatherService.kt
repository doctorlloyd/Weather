package com.lloyd.weather.data.remote.service

import com.lloyd.weather.API_KEY
import com.lloyd.weather.data.models.LocationWeather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherService {
    @GET("weather?q=Pretoria,Gauteng&appid=$API_KEY")
    suspend fun fetchWeather(): Response<LocationWeather>

    @GET("weather?q=Pretoria,Gauteng&appid=$API_KEY")
    suspend fun getWeather(): Response<LocationWeather>
}
