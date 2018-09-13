package com.movies.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
data class DBSubjectResult(
        val count: Int,
        val start: Int,
        val total: Int,
        val title: String,
        val date: String? = null,
        val subjects: List<Subject>? = null
)