package com.lloyd.weather.ui.weather.adapter

import androidx.recyclerview.widget.RecyclerView
import com.lloyd.weather.data.models.Weather
import com.lloyd.weather.databinding.WeatherBinding
import com.lloyd.weather.ui.base.listeners.RecyclerItemListener


class WeatherViewHolder(private val itemBinding: WeatherBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(LocationWeather: Weather, recyclerItemListener: RecyclerItemListener) {
        itemBinding.tvCaption.text = LocationWeather.main
        itemBinding.tvName.text = LocationWeather.description
//        Picasso.get().load(LocationWeather.thumb).placeholder(R.drawable.ic_healthy_food).error(R.drawable.ic_healthy_food).into(itemBinding.ivWeatherItemImage)
        itemBinding.rlWeatherItem.setOnClickListener { recyclerItemListener.onItemSelected(LocationWeather) }
    }
}

