package com.movies.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/9/3.
 * @description
 * @version
 */
data class Celebrity(
        val website: String,
        val mobile_url: String,
        val aka_en: List<String>? = null,
        val name: String,
        val works: List<Work>? = null,
        val name_en: String,
        val gender: String,
        val professions: List<String>? = null,
        val avatars: Avatars,
        val summary: String,
        val photos: List<Photo>? = null,
        val birthday: String,
        val aka: List<String>? = null,
        val alt: String,
        val born_place: String,
        val constellation: String,
        val id: String
)