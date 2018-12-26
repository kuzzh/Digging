package com.movies.data.entities

import java.util.*

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
interface IEntity {
    val id: Long

    fun generateStableId(): Long {
        return Objects.hash(id).toLong()
    }
}