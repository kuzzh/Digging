package com.movies.dytt.repositories

import com.movies.dytt.entities.Seed
import com.movies.dytt.entities.SeedList
import com.movies.dytt.services.DYTTApi
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Singleton
class RemoteDyttSource @Inject constructor(
        private val api: DYTTApi
) {
    fun searchMovie(page: Int,
                    search: String): Flowable<SeedList<Seed>> {
        return api.searchMovie(categoryId = 0, page = page, search = search)
    }

    fun getMovieList(categoryId: Int,
                     page: Int): Flowable<SeedList<Seed>> {
        return api.getMovieList(categoryId, page)
    }
}