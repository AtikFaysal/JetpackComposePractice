package com.jetpack.domain.base

sealed class ApiResult<out R> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Loading<out T>(val loading: Boolean) : ApiResult<T>()
    data class Error<out T>(val message: String,val code:Int) : ApiResult<T>()
    data class NetworkError<out T>(val message: String) : ApiResult<T>()
}