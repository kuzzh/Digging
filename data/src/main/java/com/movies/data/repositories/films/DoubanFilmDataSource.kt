package com.movies.data.repositories.films

import com.movies.data.RetrofitRunner
import com.movies.data.entities.Failure
import com.movies.data.entities.Film
import com.movies.data.entities.Result
import com.movies.data.mappers.SubjectToFilm
import com.movies.douban.services.DoubanService
import com.movies.extensions.executeWithRetry
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
class DoubanFilmDataSource @Inject constructor(
        private val douban: DoubanService,
        private val mapper: SubjectToFilm,
        private val runner: RetrofitRunner
) : FilmDataSource {
    override suspend fun getFilm(film: Film): Result<Film> {
        val doubanId = film.doubanId

        return if (doubanId != null) {
            fetchFromDouban(doubanId)
        } else {
            Failure(IllegalArgumentException("doubanId for film does not exist: [$film]"))
        }
    }

    private suspend fun fetchFromDouban(doubanId: String) = runner.executeForResponse(mapper) {
        douban.getSubjectDetail(doubanId).executeWithRetry()
    }
}