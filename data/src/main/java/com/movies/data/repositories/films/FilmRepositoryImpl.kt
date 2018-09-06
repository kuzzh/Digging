package com.movies.data.repositories.films

import com.movies.data.entities.Film
import com.movies.data.entities.Success
import com.movies.inject.DOUBAN
import com.movies.inject.DYTT
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
        @DOUBAN private val douban: FilmDataSource,
        @DYTT private val dytt: FilmDataSource
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
        val dyttJob = async(dispatchers.io) { dytt.getFilm(localFilm) }

        val doubanResult = doubanJob.await()
        val dyttResult = dyttJob.await()

        local.saveFilm(mergeFilm(localFilm, (doubanResult as? Success)?.data ?: Film.EMPTY_FILM,
                (dyttResult as? Success)?.data ?: Film.EMPTY_FILM))

        if (doubanResult is Success && dyttResult is Success) {
            local.updateLastRequest(id)
        }
    }

    override fun needsUpdate(id: Long): Boolean {
        return local.lastRequestBefore(id, Period.ofDays(7))
    }

    private fun mergeFilm(local: Film, douban: Film, dytt: Film) = local.copy(
            doubanId = douban.doubanId ?: local.doubanId,
            dyttId = dytt.dyttId ?: local.dyttId,
            title = douban.title ?: local.title,
            originalTitle = douban.originalTitle ?: local.originalTitle,
            summary = douban.summary ?: local.summary,
            subType = douban.subType ?: local.subType,
            year = douban.year ?: local.year,
            alt = douban.alt ?: local.alt,
            ratingsCount = douban.ratingsCount ?: local.ratingsCount,
            images = douban.images ?: local.images,
            downloadUrl = dytt.downloadUrl ?: local.downloadUrl
    )

    override fun observeFilm(id: Long) = local.observeFilm(id)
}