package com.movies.core.douban.entities

import com.google.gson.annotations.SerializedName

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
data class Celebrity(
        val website: String,
        @SerializedName("mobile_url")
        val mobileUrl: String,
        @SerializedName("aka_en")
        val akaEn: List<String>? = null,
        val name: String,
        val works: List<Work>? = null,
        @SerializedName("name_en")
        val nameEn: String,
        val gender: String,
        val professions: List<String>? = null,
        val avatars: Avatar,
        val summary: String,
        val photos: List<Photo>? = null,
        val birthday: String,
        val aka: List<String>? = null,
        val alt: String,
        @SerializedName("born_place")
        val bornPlace: String,
        val constellation: String,
        val id: String
) {
}