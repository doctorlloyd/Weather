package com.lloyd.weather.data

import com.lloyd.weather.data.models.LocationWeather
import com.lloyd.weather.data.models.WeatherList
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun requestWeather(): Flow<Resource<LocationWeather>>
}
