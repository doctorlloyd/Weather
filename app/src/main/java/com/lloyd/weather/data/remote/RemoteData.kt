package com.lloyd.weather.data.remote

import com.lloyd.weather.data.Resource
import com.lloyd.weather.data.models.LocationWeather
import com.lloyd.weather.data.error.NETWORK_ERROR
import com.lloyd.weather.data.error.NO_INTERNET_CONNECTION
import com.lloyd.weather.data.models.Weather
import com.lloyd.weather.data.models.WeatherList
import com.lloyd.weather.data.remote.service.WeatherService
import com.lloyd.weather.utils.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject
constructor(private val serviceGenerator: ServiceGenerator, private val networkConnectivity: NetworkConnectivity) :
    RemoteDataSource {
    override suspend fun requestWeather(): Resource<WeatherList> {
        val weatherService = serviceGenerator.createService(WeatherService::class.java)
        return when (val response = processCall(weatherService::fetchWeather)) {
            is List<*> -> {
                Resource.Success(data = WeatherList(response as ArrayList<LocationWeather>))
            }
            else -> {
                Resource.DataError(errorCode = response as Int)
            }
        }
    }

    private suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}
