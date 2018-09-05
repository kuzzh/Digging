package com.movies.data

import com.movies.data.entities.Failure
import com.movies.data.entities.Result
import com.movies.data.entities.Success
import com.movies.data.mappers.Mapper
import com.movies.extensions.bodyOrThrow
import com.movies.extensions.toException
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/22.
 * @description
 * @version
 */
@Singleton
class RetrofitRunner @Inject constructor() {
    suspend fun <T, E> executeForResponse(mapper: Mapper<T, E>, request: suspend () -> Response<T>): Result<E> {
        return try {
            val response = request()
            if (response.isSuccessful) {
                val okHttpNetworkResponse = response.raw().networkResponse()
                val notModified = okHttpNetworkResponse == null || okHttpNetworkResponse.code() == 304
                Success(data = mapper.map(response.bodyOrThrow()), responseModified = !notModified)
            } else {
                Failure(response.toException())
            }
        } catch (e: Exception) {
            Failure(e)
        }
    }

    suspend fun <T> executeForResponse(request: suspend () -> Response<T>): Result<T> {
        val unitMapper = object : Mapper<T, T> {
            override fun map(from: T) = from
        }
        return executeForResponse(unitMapper, request)
    }

    suspend fun <T, E> mapperForResponse(mapper: Mapper<T, E>, request: suspend () -> T?): Result<E> {
        return try {
            val response = request()
            if (response != null) {
                Success(data = mapper.map(response))
            } else {
                Failure(Exception("result is null"))
            }
        } catch (e: Exception) {
            Failure(e)
        }
    }
}