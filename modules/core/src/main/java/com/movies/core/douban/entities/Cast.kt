package com.movies.core.douban.entities

import com.google.gson.annotations.SerializedName

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
data class Cast (
        val id: String,
        val name: String,
        @SerializedName("name_en")
        val nameEn: String? = null,
        val alt: String,
        val avatars: Avatar? = null
)