package com.jetpack.data.mapper


import com.jetpack.domain.base.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface Mapper<R,E>{
    fun mapFromApiResponse(type:R):E
}

fun<R,E> mapFromApiResponse(result: Flow<ApiResult<R>>, mapper: Mapper<R, E>): Flow<ApiResult<E>> {
    return result.map {
        when(it){
            is ApiResult.Success-> ApiResult.Success(mapper.mapFromApiResponse(it.data))
            is ApiResult.Error->ApiResult.Error(it.message,it.code)
            is ApiResult.Loading -> ApiResult.Loading(it.loading)
            is ApiResult.NetworkError -> ApiResult.NetworkError(it.message)
        }
    }
}