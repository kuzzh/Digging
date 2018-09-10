package com.movies.data.repositories.intheaters

import androidx.paging.DataSource
import com.movies.data.entities.Success
import com.movies.data.repositories.films.FilmRepository
import com.movies.data.repositories.films.LocalFilmStore
import com.movies.data.resultentities.InTheaterEntryWithFilm
import com.movies.extensions.parallelForEach
import com.movies.utils.AppCoroutineDispatchers
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
@Singleton
class InTheatersRepository @Inject constructor(
        private val dispatchers: AppCoroutineDispatchers,
        private val inTheaters: DoubanInTheatersDataSource,
        private val localIntheater: LocalinTheatersStore,
        private val filmStore: LocalFilmStore,
        private val repository: FilmRepository
) {

    fun observeForPaging(): DataSource.Factory<Int, InTheaterEntryWithFilm> = localIntheater.observeForPaging()

    fun observeForFlowable(): Flowable<List<InTheaterEntryWithFilm>> = localIntheater.observeForFlowable(10, 0)

    suspend fun refresh() {
        updateIntheaterFilms(0, true)
    }

    suspend fun loadNextPage() {
        val lastPage = localIntheater.getLastPage()
        if (lastPage != null) {
            updateIntheaterFilms(lastPage + 1, false)
        } else {
            refresh()
        }
    }

    private suspend fun updateIntheaterFilms(page: Int, resetOnSave: Boolean) {
        val response = inTheaters.getInTheaters(page, 20)
        when (response) {
            is Success -> {
                response.data.map { (film, entry) ->
                    val filmId = filmStore.getIdOrSavePlaceholder(film)
                    entry.copy(filmId = filmId, page = page)
                }.also { entries ->
                    if (resetOnSave) {
                        localIntheater.deleteAll()
                    }
                    localIntheater.saveInTheatersPage(page, entries)
                    entries.parallelForEach(dispatchers.io) { entry ->
                        if (repository.needsUpdate(entry.filmId)) {
                            repository.updateFilm(entry.filmId)
                        }
                    }
                }
            }
        }
    }
}