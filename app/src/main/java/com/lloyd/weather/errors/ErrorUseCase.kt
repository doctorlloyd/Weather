package com.lloyd.weather.errors

import com.lloyd.weather.data.error.Error


interface ErrorUseCase {
    fun getError(errorCode: Int): Error
}
