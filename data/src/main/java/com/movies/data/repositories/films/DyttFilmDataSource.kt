package com.movies.data.repositories.films

import com.movies.data.RetrofitRunner
import com.movies.data.entities.Failure
import com.movies.data.entities.Film
import com.movies.data.entities.Result
import com.movies.data.mappers.SeedToFilm
import com.movies.dytt.services.DYTTService
import com.movies.extensions.executeWithRetry
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
class DyttFilmDataSource @Inject constructor(
        private val dytt: DYTTService,
        private val mapper: SeedToFilm,
        private val runner: RetrofitRunner
) : FilmDataSource {
    override suspend fun getFilm(film: Film): Result<Film> {
        val dyttId = film.dyttId
        return if (dyttId != null) {
            runner.executeForResponse(mapper) {
                dytt.getMovieDetail(film.categoryId ?: 0, dyttId).executeWithRetry()
            }
        } else {
            Failure(IllegalArgumentException("dyttId for film does not exist [$film]"))
        }
    }
}