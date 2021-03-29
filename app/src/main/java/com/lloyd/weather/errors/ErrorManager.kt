package com.lloyd.weather.errors

import com.lloyd.weather.data.error.mapper.ErrorMapper
import com.lloyd.weather.data.error.Error
import javax.inject.Inject

class ErrorManager @Inject constructor(private val errorMapper: ErrorMapper) : ErrorUseCase {
    override fun getError(errorCode: Int): Error {
        return Error(code = errorCode, description = errorMapper.errorsMap.getValue(errorCode))
    }
}
