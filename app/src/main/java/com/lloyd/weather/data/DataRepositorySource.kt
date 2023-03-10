package com.lloyd.weather.data

import com.lloyd.weather.data.models.LocationWeather
import com.lloyd.weather.data.models.Weather
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun requestWeatherForLocation(): Flow<Resource<LocationWeather>>
}
