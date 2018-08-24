package com.movies.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
data class DBListResult<T>(
        private val count: Int,
        private val start: Int,
        private val total: Int,
        private val title: String,
        private val date: String,
        private val subjects: List<T>? = null
)