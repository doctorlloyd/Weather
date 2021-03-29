package com.lloyd.weather.ui.weather

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.lloyd.weather.R
import com.lloyd.weather.WEATHER_ITEM_KEY
import com.lloyd.weather.data.Resource
import com.lloyd.weather.data.models.LocationWeather
import com.lloyd.weather.data.models.WeatherList
import com.lloyd.weather.databinding.HomeActivityBinding
import com.lloyd.weather.ui.base.BaseActivity
import com.lloyd.weather.ui.details.DetailsActivity
import com.lloyd.weather.ui.weather.adapter.WeatherAdapter
import com.lloyd.weather.utils.*
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeatherListActivity : BaseActivity() {
    private lateinit var binding: HomeActivityBinding

    private val weatherListViewModel: WeatherListViewModel by viewModels()
    private lateinit var weatherAdapter: WeatherAdapter

    override fun initViewBinding() {
        binding = HomeActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.weather)
        val layoutManager = LinearLayoutManager(this)
        binding.rvWeatherList.layoutManager = layoutManager
        binding.rvWeatherList.setHasFixedSize(true)
        weatherListViewModel.getWeather()
    }

    private fun bindListData(weather: WeatherList) {
        if (!(weather.weatherList.isNullOrEmpty())) {
            weatherAdapter = WeatherAdapter(weatherListViewModel, weather.weatherList)
            binding.rvWeatherList.adapter = weatherAdapter
            showDataView(true)
        } else {
            showDataView(false)
        }
    }

    private fun navigateToDetailsScreen(navigateEvent: SingleEvent<LocationWeather>) {
        navigateEvent.getContentIfNotHandled()?.let {
            val nextScreenIntent = Intent(this, DetailsActivity::class.java).apply {
                putExtra(WEATHER_ITEM_KEY, it)
            }
            startActivity(nextScreenIntent)
        }
    }

    private fun observeSnackBarMessages(event: LiveData<SingleEvent<Any>>) {
        binding.root.setupSnackbar(this, event, Snackbar.LENGTH_LONG)
    }

    private fun observeToast(event: LiveData<SingleEvent<Any>>) {
        binding.root.showToast(this, event, Snackbar.LENGTH_LONG)
    }

    private fun showDataView(show: Boolean) {
        binding.tvNoData.visibility = if (show) GONE else VISIBLE
        binding.rvWeatherList.visibility = if (show) VISIBLE else GONE
        binding.pbLoading.toGone()
    }

    private fun showLoadingView() {
        binding.pbLoading.toVisible()
        binding.tvNoData.toGone()
        binding.rvWeatherList.toGone()
    }

    private fun handleWeatherList(status: Resource<WeatherList>) {
        when (status) {
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> status.data?.let { bindListData(weather = it) }
            is Resource.DataError -> {
                showDataView(false)
                status.errorCode?.let { weatherListViewModel.showToastMessage(it) }
            }
        }
    }

    override fun observeViewModel() {
        observe(weatherListViewModel.weatherLiveData, ::handleWeatherList)
        observeEvent(weatherListViewModel.openWeatherDetails, ::navigateToDetailsScreen)
        observeSnackBarMessages(weatherListViewModel.showSnackBar)
        observeToast(weatherListViewModel.showToast)

    }
}
