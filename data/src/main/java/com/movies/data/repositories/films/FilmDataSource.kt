package com.movies.data.repositories.films

import com.movies.data.entities.Film
import com.movies.data.entities.Result

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
interface FilmDataSource {
    suspend fun getFilm(film: Film): Result<Film>
}