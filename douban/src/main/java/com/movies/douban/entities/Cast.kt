package com.movies.douban.entities

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
data class Cast(
        private val id: String,
        private val name: String,
        private val alt: String,
        private val avatars: Avatars
)