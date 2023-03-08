package com.lloyd.weather

const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
const val WEATHER_ITEM_KEY = "WEATHER_ITEM_KEY"
const val API_KEY = "a0275f623914e5be09d2659de218d877"


/**
* Geocoding API
* */

//http://api.openweathermap.org/geo/1.0/zip?zip={zip code},{country code}&appid={API key}
//http://api.openweathermap.org/geo/1.0/reverse?lat={lat}&lon={lon}&limit={limit}&appid={API key}
//http://api.openweathermap.org/geo/1.0/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}

/***
 * Built-in API request by city name
 * Call 5 day / 3 hour forecast data
 * *** How to make an API call
 * */
//api.openweathermap.org/data/2.5/forecast?q={city name}&appid={API key}
//api.openweathermap.org/data/2.5/forecast?q={city name},{country code}&appid={API key}
//api.openweathermap.org/data/2.5/forecast?q={city name},{state code},{country code}&appid={API key}
//api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}&appid={API key}