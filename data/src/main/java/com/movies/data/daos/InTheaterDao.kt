package com.movies.data.daos

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.movies.data.entities.InTheaterFilmEntry
import com.movies.data.resultentities.InTheaterEntryWithFilm
import io.reactivex.Flowable

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
@Dao
abstract class InTheaterDao : PaginatedEntryDao<InTheaterFilmEntry, InTheaterEntryWithFilm> {

    @Transaction
    @Query("SELECT * FROM in_theaters ORDER BY page, page_order LIMIT :count OFFSET :offset")
    abstract override fun entriesFlowable(count: Int, offset: Int): Flowable<List<InTheaterEntryWithFilm>>

    @Transaction
    @Query("SELECT * FROM in_theaters ORDER BY page, page_order")
    abstract override fun entriesDataSource(): DataSource.Factory<Int, InTheaterEntryWithFilm>

    @Query("DELETE FROM in_theaters WHERE page = :page")
    abstract override fun deletePage(page: Int)

    @Query("DELETE FROM in_theaters")
    abstract override fun deleteAll()

    @Query("SELECT MAX(page) FROM in_theaters")
    abstract override fun getLastPage(): Int?

    @Query("SELECT COUNT(id) FROM IN_THEATERS")
    abstract fun getPageCount(): Int?
}