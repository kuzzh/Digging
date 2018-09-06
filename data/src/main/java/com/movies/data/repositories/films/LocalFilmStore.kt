package com.movies.data.repositories.films

import com.movies.data.DatabaseTransactionRunner
import com.movies.data.daos.EntityInserter
import com.movies.data.daos.FilmsDao
import com.movies.data.daos.LastRequestDao
import com.movies.data.entities.Film
import com.movies.data.entities.Request
import io.reactivex.Flowable
import org.threeten.bp.temporal.TemporalAmount
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
class LocalFilmStore @Inject constructor(
        private val inserter: EntityInserter,
        private val dao: FilmsDao,
        private val lastRequestDao: LastRequestDao,
        private val runner: DatabaseTransactionRunner
) {

    fun getFilm(id: Long) = dao.getFilmWithId(id)

    fun observeFilm(id: Long): Flowable<Film> = dao.getFlowableFilmWithId(id)

    fun getIdForDoubanId(doubanId: String) = dao.getIdForDoubanId(doubanId)

    fun saveFilm(film: Film) = inserter.insertOrUpdate(dao, film)

    fun lastRequestBefore(id: Long, threshold: TemporalAmount): Boolean {
        return lastRequestDao.isRequestBefore(Request.FILM_DETAIL, id, threshold)
    }

    fun updateLastRequest(id: Long) = lastRequestDao.updateLastRequest(Request.FILM_DETAIL, id)

    fun getIdOrSavePlaceholder(film: Film): Long = runner {
        film.doubanId?.let { dao.getFilmWithDoubanId(it)?.id }
                ?: film.dyttId?.let { dao.getFilmWithDyttId(it)?.id }
                ?: dao.insert(film)
    }
}