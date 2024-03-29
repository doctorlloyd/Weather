package com.lloyd.weather.ui.details

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import com.lloyd.weather.R
import com.lloyd.weather.WEATHER_ITEM_KEY
import com.lloyd.weather.data.models.LocationWeather
import com.lloyd.weather.data.models.Weather
import com.lloyd.weather.databinding.DetailsLayoutBinding
import com.lloyd.weather.ui.base.BaseActivity
import com.lloyd.weather.utils.observe
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class DetailsActivity : BaseActivity() {

    private val viewModel: DetailsViewModel by viewModels()

    private lateinit var binding: DetailsLayoutBinding

    override fun initViewBinding() {
        binding = DetailsLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initIntentData(intent.getParcelableExtra(WEATHER_ITEM_KEY) ?: Weather())
    }

    override fun observeViewModel() {
        observe(viewModel.weatherData, ::initializeView)
    }

    private fun initializeView(LocationWeather: Weather) {
        binding.tvName.text = LocationWeather.main
        binding.tvHeadline.text = LocationWeather.description
        binding.tvDescription.text = LocationWeather.icon
//        Picasso.get().load(LocationWeather).placeholder(R.drawable.ic_healthy_food_small)
//                .into(binding.ivweatherImage)

    }
}
