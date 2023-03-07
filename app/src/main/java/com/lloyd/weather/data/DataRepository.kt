package com.lloyd.weather.data

import com.lloyd.weather.data.models.LocationWeather
import com.lloyd.weather.data.models.WeatherList
import com.lloyd.weather.data.remote.RemoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DataRepository @Inject constructor(private val remoteRepository: RemoteData, private val ioDispatcher: CoroutineContext) :
    DataRepositorySource {

    override suspend fun requestWeather(): Flow<Resource<LocationWeather>> {
        return flow {
            emit(remoteRepository.requestWeather())
        }.flowOn(ioDispatcher)
    }
}
