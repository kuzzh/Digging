package com.movies.data

import com.movies.data.entities.MovieEntity

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
interface Entry : MovieEntity {
    val entryId: Long
}

interface MultipleEntry : Entry {
    val otherEntryId: Long
}

interface PaginatedEntry : Entry {
    val page: Int
}