package com.movies.data.daos

import com.movies.data.PaginatedEntry
import com.movies.data.resultentities.EntryWithShow

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
interface PaginatedEntryDao<EC : PaginatedEntry, LI : EntryWithShow<EC>> : EntryDao<EC, LI> {
    fun deletePage(page: Int)
    fun getLastPage(): Int?
}