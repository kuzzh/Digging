package com.movies.core.douban.entities

import com.google.gson.annotations.SerializedName

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
data class Photo(
        @SerializedName("photos_count")
        val photosCount: Long,
        val thumb: String,
        val icon: String,
        val author: Author,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("album_id")
        val albumId: String,
        val cover: String,
        val id: String,
        @SerializedName("prev_photo")
        val prevPhoto: String,
        @SerializedName("album_url")
        val albumUrl: String,
        @SerializedName("comments_count")
        val commentsCount: Long,
        val image: String,
        @SerializedName("recs_count")
        val recsCount: Int,
        val position: Int,
        val alt: String,
        @SerializedName("album_title")
        val albumTitle: String,
        @SerializedName("next_photo")
        val nextPhoto: String,
        @SerializedName("subject_id")
        val subjectId: String,
        val desc: String
)