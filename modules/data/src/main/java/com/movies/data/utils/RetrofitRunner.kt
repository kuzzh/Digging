package com.movies.data.utils

import com.movies.core.Error
import com.movies.core.Result
import com.movies.core.Success
import com.movies.core.extensions.bodyOrThrow
import com.movies.core.extensions.toException
import com.movies.data.mappers.Mapper
import kotlinx.coroutines.Deferred
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
@Singleton
class RetrofitRunner @Inject constructor() {

    suspend fun <T, E> executeForResponse(mapper: Mapper<T, E>,
                                          request: suspend  () -> Deferred<Response<T>>) : Result<E> {
        return try {
            val response = request().await()
            if (response.isSuccessful) {
                val networkResponse = response.raw().networkResponse()
                val modified = networkResponse == null || networkResponse.code() == 304
                Success(data = mapper.map(response.bodyOrThrow()!!), modified = !modified)
            } else {
                Error(response.toException())
            }
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun <T> executeForResponse(request: suspend () -> Response<T>): Result<T> {
        return try {
            val response = request()
            if (response.isSuccessful) {
                val networkResponse = response.raw().networkResponse()
                val modified = networkResponse == null || networkResponse.code() == 304
                Success(data = response.bodyOrThrow(), modified = !modified)
            } else {
                Error(response.toException())
            }
        } catch (e: Exception) {
            Error(e)
        }
    }
}