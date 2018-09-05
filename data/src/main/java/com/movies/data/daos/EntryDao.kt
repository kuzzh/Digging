package com.movies.data.daos

import androidx.paging.DataSource
import com.movies.data.Entry
import com.movies.data.resultentities.EntryWithShow
import io.reactivex.Flowable

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
interface EntryDao<EC : Entry, LI : EntryWithShow<EC>> : EntityDao<EC> {
    fun entriesFlowable(count: Int, offset: Int): Flowable<List<LI>>
    fun entriesDataSource(): DataSource.Factory<Int, LI>
    fun deleteAll()
}