package com.lloyd.weather.ui.weather

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lloyd.weather.data.DataRepositorySource
import com.lloyd.weather.data.Resource
import com.lloyd.weather.data.models.LocationWeather
import com.lloyd.weather.data.models.WeatherList
import com.lloyd.weather.ui.base.BaseViewModel
import com.lloyd.weather.utils.SingleEvent
import com.lloyd.weather.utils.wrapEspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherListViewModel @Inject
constructor(private val dataRepositoryRepository: DataRepositorySource) : BaseViewModel() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val weatherLiveDataPrivate = MutableLiveData<Resource<WeatherList>>()
    val weatherLiveData: LiveData<Resource<WeatherList>> get() = weatherLiveDataPrivate


    /**
     * UI actions as event, user action is single one time event, Shouldn't be multiple time consumption
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val openWeatherDetailsPrivate = MutableLiveData<SingleEvent<LocationWeather>>()
    val openWeatherDetails: LiveData<SingleEvent<LocationWeather>> get() = openWeatherDetailsPrivate

    /**
     * Error handling as UI
     */
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showSnackBarPrivate = MutableLiveData<SingleEvent<Any>>()
    val showSnackBar: LiveData<SingleEvent<Any>> get() = showSnackBarPrivate

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    private val showToastPrivate = MutableLiveData<SingleEvent<Any>>()
    val showToast: LiveData<SingleEvent<Any>> get() = showToastPrivate


    fun getWeather() {
        viewModelScope.launch {
            weatherLiveDataPrivate.value = Resource.Loading()
            wrapEspressoIdlingResource {
                dataRepositoryRepository.requestWeather().collect {
                    weatherLiveDataPrivate.value = it
                }
            }
        }
    }

    fun openWeatherDetails(weather: LocationWeather) {
        openWeatherDetailsPrivate.value = SingleEvent(weather)
    }

    fun showToastMessage(errorCode: Int) {
        val error = errorManager.getError(errorCode)
        showToastPrivate.value = SingleEvent(error.description)
    }
}
