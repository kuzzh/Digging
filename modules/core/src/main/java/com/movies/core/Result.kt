package com.movies.core

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
sealed class Result<T> {
    open fun get(): T? = null
}

data class Success<T>(val data: T? = null,
                      val modified: Boolean) : Result<T>() {
    override fun get(): T? = data
}

data class Error<T>(val exception: Exception) : Result<T>()