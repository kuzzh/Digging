package com.movies.extensions

import kotlinx.coroutines.experimental.delay
import retrofit2.Call
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

/**
 * @author donnieSky
 * @created_at 2018/8/21.
 * @description
 * @version
 */
fun <T> Call<T>.fetchBody(): T = execute().bodyOrThrow()

fun <T> Response<T>.bodyOrThrow(): T {
    if (!isSuccessful) throw HttpException(this)
    return body()!!
}

fun <T> Response<T>.toException() = HttpException(this)

suspend inline fun <T> Call<T>.executeWithRetry(
        firstDelay: Int = 100,
        maxAttempts: Int = 3,
        shouldRetry: (Exception) -> Boolean = ::defaultShouldRetry
): Response<T> {
    var nextDelay = firstDelay
    repeat(maxAttempts - 1) { attempt ->
        try {
            val call = if (isExecuted) clone() else this
            return call.execute()
        } catch (e: Exception) {
            if (attempt == (maxAttempts - 1) || !shouldRetry(e)) {
                throw e
            }
        }

        delay(nextDelay)

        nextDelay *= 2
    }

    throw IllegalStateException("Unknown exception from executeWithRetry")
}

suspend inline fun <T> Call<T>.fetchBodyWithRetry(
        firstDelay: Int = 100,
        maxAttempts: Int = 3,
        shouldRetry: (Exception) -> Boolean = ::defaultShouldRetry
) = executeWithRetry(firstDelay, maxAttempts, shouldRetry).bodyOrThrow()

fun defaultShouldRetry(exception: Exception) = when (exception) {
    is HttpException -> exception.code() == 429
    is IOException -> true
    else -> false
}