package com.movies.dytt.entities

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
data class MovieList<T>(
        val total: Long,
        val rows: List<T>? = null
)