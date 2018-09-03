package com.movies.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/9/3.
 * @description
 * @version
 */
data class Photo(
        val photos_count: Long,
        val thumb: String,
        val icon: String,
        val author: Author,
        val created_at: String,
        val album_id: String,
        val cover: String,
        val id: String,
        val prev_photo: String,
        val album_url: String,
        val comments_count: Long,
        val image: String,
        val recs_count: Int,
        val position: Int,
        val alt: String,
        val album_title: String,
        val next_photo: String,
        val subject_id: String,
        val desc: String
)