package com.movies.dytt.entities

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
data class Movie(
        val id: Long,
        val categoryId: Int,
        val name: String,
        val publishTime: String,
        val homePicUrl: String,
        val content: String,
        val pics: String,
        val downloadUrl: String
)