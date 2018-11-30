package com.movies.core.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
data class CelebrityPhotos(
        val count: Int,
        val photos: List<Photo>? = null,
        val celebrity: Celebrity,
        val total: Int,
        val start: Int
)