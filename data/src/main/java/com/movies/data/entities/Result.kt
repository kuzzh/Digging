package com.movies.data.entities

/**
 * @author donnieSky
 * @created_at 2018/8/22.
 * @description
 * @version
 */
sealed class Result<T>

data class Success<T>(val data: T,
                      val responseModified: Boolean = true) : Result<T>()

data class Failure<T>(val exception: Exception) : Result<T>()