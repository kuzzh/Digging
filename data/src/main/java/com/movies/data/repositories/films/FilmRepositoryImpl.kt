package com.movies.data.repositories.films

import com.movies.data.entities.Film
import com.movies.data.entities.Success
import com.movies.inject.DOUBAN
import com.movies.utils.AppCoroutineDispatchers
import kotlinx.coroutines.experimental.async
import org.threeten.bp.Period
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
@Singleton
class FilmRepositoryImpl @Inject constructor(
        private val dispatchers: AppCoroutineDispatchers,
        private val local: LocalFilmStore,
        @DOUBAN private val douban: FilmDataSource
) : FilmRepository {
    override suspend fun getFilm(id: Long): Film {
        if (needsUpdate(id)) {
            updateFilm(id)
        }
        return local.getFilm(id)!!
    }

    override suspend fun updateFilm(id: Long) {
        val localFilm = local.getFilm(id) ?: Film.EMPTY_FILM
        val doubanJob = async(dispatchers.io) { douban.getFilm(localFilm) }

        val doubanResult = doubanJob.await()

        local.saveFilm(mergeFilm(localFilm, (doubanResult as? Success)?.data ?: Film.EMPTY_FILM))

        if (doubanResult is Success) {
            local.updateLastRequest(id)
        }
    }

    override fun needsUpdate(id: Long): Boolean {
        return local.lastRequestBefore(id, Period.ofDays(7))
    }

    private fun mergeFilm(local: Film, douban: Film) = local.copy(
            doubanId = douban.doubanId ?: local.doubanId,
            title = douban.title ?: local.title,
            originalTitle = douban.originalTitle ?: local.originalTitle,
            summary = douban.summary ?: local.summary,
            subType = douban.subType ?: local.subType,
            year = douban.year ?: local.year,
            alt = douban.alt ?: local.alt,
            ratingsCount = douban.ratingsCount ?: local.ratingsCount,
            images = douban.images ?: local.images
    )

    override fun observeFilm(id: Long) = local.observeFilm(id)
}