package com.movies.data.mappers

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
interface Mapper<F, T> {
    fun map(from: F?): T?
}

interface IndexedMapper<F, T> {
    fun map(index: Int, from: F): T
}