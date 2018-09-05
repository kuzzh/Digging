package com.movies.dytt.entities

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
data class Seed(
        val id: Long,
        val categoryId: Int,
        val name: String,
        val publishTime: String,
        val homePicUrl: String? = null,
        val content: String? = null,
        val pics: String? = null,
        val downloadUrl: String? = null
)