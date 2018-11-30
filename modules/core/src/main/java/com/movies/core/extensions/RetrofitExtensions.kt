package com.movies.core.extensions

import retrofit2.HttpException
import retrofit2.Response

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
fun <T> Response<T>.bodyOrThrow(): T? {
    if (!isSuccessful) throw HttpException(this)
    return body()
}

fun <T> Response<T>.toException() = HttpException(this)