package com.movies.data.entities

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
interface MovieEntity {
    val id: Long
}

interface DoubanIdEntity {
    val doubanId: String?
}

interface DyttIdEntity {
    val dyttId: Long?
}