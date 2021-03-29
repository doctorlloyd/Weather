package com.lloyd.weather.ui.details

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lloyd.weather.data.DataRepositorySource
import com.lloyd.weather.data.Resource
import com.lloyd.weather.data.models.LocationWeather
import com.lloyd.weather.ui.base.BaseViewModel
import com.lloyd.weather.utils.SingleEvent
import com.lloyd.weather.utils.wrapEspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
open class DetailsViewModel @Inject constructor(private val dataRepository: DataRepositorySource) : BaseViewModel() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val weatherPrivate = MutableLiveData<LocationWeather>()
    val weatherData: LiveData<LocationWeather> get() = weatherPrivate

    /**
     * UI actions as event, user action is single one time event, Shouldn't be multiple time consumption
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openWeatherDetailsPrivate = MutableLiveData<SingleEvent<LocationWeather>>()
    val openWeatherDetails: LiveData<SingleEvent<LocationWeather>> get() = openWeatherDetailsPrivate

    fun initIntentData(weather: LocationWeather) {
        weatherPrivate.value = weather
    }

//    fun getWeather() {
//        viewModelScope.launch {
//            weatherPrivate.value = Resource.Loading()
//            wrapEspressoIdlingResource {
//                dataRepository.requestWeather().collect {
//                    weatherPrivate.value = it
//                }
//            }
//        }
//    }
}
