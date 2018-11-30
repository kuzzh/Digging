package com.movies.core.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
data class SubjectResponse(
        val count: Int,
        val start: Int,
        val total: Int,
        val title: String,
        val date: String? = null,
        val subjects: List<Subject>? = null
) {
}