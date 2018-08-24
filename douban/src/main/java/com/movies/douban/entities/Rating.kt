package com.movies.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
data class Rating(
        private val max: Int,
        private val average: Double,
        private val stars: String,
        private val min: Int
)