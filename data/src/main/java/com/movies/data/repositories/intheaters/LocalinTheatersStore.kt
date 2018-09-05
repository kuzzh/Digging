package com.movies.data.repositories.intheaters

import androidx.paging.DataSource
import com.movies.data.DatabaseTransactionRunner
import com.movies.data.daos.InTheaterDao
import com.movies.data.entities.InTheaterEntry
import com.movies.data.resultentities.InTheaterEntryWithFilm
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
class LocalinTheatersStore @Inject constructor(
        private val runner: DatabaseTransactionRunner,
        private val dao: InTheaterDao
) {

    fun observeForFlowable(count: Int, offset: Int): Flowable<List<InTheaterEntryWithFilm>> {
        return dao.entriesFlowable(count, offset)
    }

    fun observeForPaging(): DataSource.Factory<Int, InTheaterEntryWithFilm> {
        return dao.entriesDataSource()
    }

    fun saveInTheatersPage(page: Int, entries: List<InTheaterEntry>) = runner {
        dao.deletePage(page)
        dao.insertAll(entries)
    }

    fun deleteAll() = dao.deleteAll()

    fun getLastPage(): Int? = dao.getLastPage()

}