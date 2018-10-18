package com.movies.data.entities

import java.util.*

/**
 * @author donnieSky
 * @created_at 2018/10/18.
 * @description
 * @version
 */
data class Tivi(
        val name: String,
        val url: String
) {
    fun generateStableId(): Long {
        return Objects.hash(name).toLong()
    }
}