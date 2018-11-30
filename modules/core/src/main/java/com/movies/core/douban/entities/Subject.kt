package com.movies.core.douban.entities

import com.google.gson.annotations.SerializedName

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
data class Subject(
        val id: String,
        val title: String,
        val summary: String? = null,
        @SerializedName("mobile_url")
        val mobileUrl: String,
        @SerializedName("share_url")
        val shareUrl: String,
        @SerializedName("schedule_url")
        val scheduleUrl: String,
        @SerializedName("original_title")
        val originalTitle: String,
        val subType: String,
        val year: String,
        val alt: String,
        val countries: List<String>? = null,
        val genres: List<String>? = null,
        val aka: List<String>? = null,
        val casts: List<Cast>? = null,
        @SerializedName("mainland_pubdate")
        val mainlandPubdate: String? = null,
        val pubdates: List<String>? = null,
        @SerializedName("has_video")
        val hasVideo: Boolean,
        val durations: List<String>? = null,
        @SerializedName("collect_count")
        val collectCount: Long,
        @SerializedName("reviews_count")
        val reviewsCount: Long,
        @SerializedName("wish_count")
        val wishCount: Long,
        @SerializedName("comments_count")
        val commentsCount: Long,
        @SerializedName("ratings_count")
        val ratingsCount: Long,
        val rating: Rating? = null,
        val directors: List<Cast>? = null,
        val images: Avatar? = null
)