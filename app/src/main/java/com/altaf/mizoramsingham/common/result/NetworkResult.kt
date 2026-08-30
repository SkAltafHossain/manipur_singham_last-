package com.altaf.manipursingham.common.result

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(val message: String, val code: Int = -1) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()
}
