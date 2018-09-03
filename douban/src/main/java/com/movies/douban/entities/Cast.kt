package com.movies.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
data class Cast(
        val id: String,
        val name: String,
        val name_en: String? = null,
        val alt: String,
        val avatars: Avatars
)