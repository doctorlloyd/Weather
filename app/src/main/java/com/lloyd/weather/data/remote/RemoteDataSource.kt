package com.lloyd.weather.data.remote

import com.lloyd.weather.data.Resource
import com.lloyd.weather.data.models.LocationWeather

internal interface RemoteDataSource {
    suspend fun requestWeather(): Resource<LocationWeather>
}
