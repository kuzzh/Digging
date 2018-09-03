package com.movies.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/8/23.
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