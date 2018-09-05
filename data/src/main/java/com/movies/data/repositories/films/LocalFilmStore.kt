package com.movies.data.repositories.films

import com.movies.data.DatabaseTransactionRunner
import com.movies.data.daos.EntityInserter
import com.movies.data.daos.FilmsDao
import com.movies.data.entities.Film
import io.reactivex.Flowable
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
        private val runner: DatabaseTransactionRunner
) {

    fun getFilm(id: Long) = dao.getFilmWithId(id)

    fun observeFilm(id: Long): Flowable<Film> = dao.getFlowableFilmWithId(id)

    fun getIdForDoubanId(doubanId: String) = dao.getIdForDoubanId(doubanId)

    fun saveFilm(film: Film) = inserter.insertOrUpdate(dao, film)

}