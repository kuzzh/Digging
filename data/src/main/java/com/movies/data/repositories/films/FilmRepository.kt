package com.movies.data.repositories.films

import com.movies.data.entities.Film
import io.reactivex.Flowable

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
interface FilmRepository {

    suspend fun getFilm(id: Long): Film

    suspend fun updateFilm(id: Long)

    fun needsUpdate(id: Long): Boolean

    fun observeFilm(id: Long): Flowable<Film>
}