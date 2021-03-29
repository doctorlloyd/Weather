package com.lloyd.weather.ui.base.listeners

import com.lloyd.weather.data.models.LocationWeather

interface RecyclerItemListener {
    fun onItemSelected(weather : LocationWeather)
}
