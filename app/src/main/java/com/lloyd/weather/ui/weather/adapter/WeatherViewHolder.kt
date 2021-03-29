package com.lloyd.weather.ui.weather.adapter

import androidx.recyclerview.widget.RecyclerView
import com.lloyd.weather.R
import com.lloyd.weather.data.models.LocationWeather
import com.lloyd.weather.databinding.WeatherBinding
import com.lloyd.weather.ui.base.listeners.RecyclerItemListener
import com.squareup.picasso.Picasso


class WeatherViewHolder(private val itemBinding: WeatherBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(LocationWeather: LocationWeather, recyclerItemListener: RecyclerItemListener) {
        itemBinding.tvCaption.text = LocationWeather.name
        itemBinding.tvName.text = LocationWeather.clouds.toString()
//        Picasso.get().load(LocationWeather.thumb).placeholder(R.drawable.ic_healthy_food).error(R.drawable.ic_healthy_food).into(itemBinding.ivWeatherItemImage)
        itemBinding.rlWeatherItem.setOnClickListener { recyclerItemListener.onItemSelected(LocationWeather) }
    }
}

