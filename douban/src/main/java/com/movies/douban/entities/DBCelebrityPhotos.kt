package com.movies.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/9/3.
 * @description
 * @version
 */
data class DBCelebrityPhotos(
        val count: Int,
        val photos: List<Photo>? = null,
        val celebrity: Celebrity,
        val total: Int,
        val start: Int
)