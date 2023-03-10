package com.lloyd.weather.ui.base.listeners

import com.lloyd.weather.data.models.Weather

interface RecyclerItemListener {
    fun onItemSelected(weather : Weather)
}
