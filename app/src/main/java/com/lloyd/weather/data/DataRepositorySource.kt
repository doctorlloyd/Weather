package com.lloyd.weather.data

import com.lloyd.weather.data.models.LocationWeather
import kotlinx.coroutines.flow.Flow

interface DataRepositorySource {
    suspend fun requestWeather(): Flow<Resource<LocationWeather>>
}
