package com.movies.core.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
data class Rating(
        val max: Int,
        val average: Double,
        val stars: String,
        val min: Int,
        val details: Map<Int, Long>? = null
)