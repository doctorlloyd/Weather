package com.lloyd.weather.ui.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lloyd.weather.data.models.Weather
import com.lloyd.weather.databinding.WeatherBinding
import com.lloyd.weather.ui.base.listeners.RecyclerItemListener
import com.lloyd.weather.ui.weather.WeatherListViewModel

class WeatherAdapter(private val weatherListViewModel: WeatherListViewModel, private val weather: List<Weather>) : RecyclerView.Adapter<WeatherViewHolder>() {

    private val onItemClickListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(weather: Weather) {
            weatherListViewModel.openWeatherDetails(weather)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemBinding = WeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weather[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return weather.size
    }
}

