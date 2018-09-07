package com.movies.data.repositories.intheaters

import com.movies.data.RetrofitRunner
import com.movies.data.entities.Film
import com.movies.data.entities.InTheaterFilmEntry
import com.movies.data.entities.Result
import com.movies.data.mappers.IndexedMapper
import com.movies.data.mappers.SubjectToFilm
import com.movies.data.mappers.pairMapperOf
import com.movies.douban.entities.Subject
import com.movies.douban.services.DoubanService
import com.movies.extensions.fetchBodyWithRetry
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
class DoubanInTheatersDataSource @Inject constructor(
        private val douban: DoubanService,
        private val runner: RetrofitRunner,
        private val mapper: SubjectToFilm
) : InTheatersDataSource {

    private val entryMapper = object : IndexedMapper<Subject, InTheaterFilmEntry> {
        override fun map(index: Int, from: Subject): InTheaterFilmEntry {
            return InTheaterFilmEntry(filmId = 0, page = 0, pageOrder = index)
        }
    }

    private val resultsMapper = pairMapperOf(mapper, entryMapper)

    override suspend fun getInTheaters(page: Int, pageSize: Int): Result<List<Pair<Film, InTheaterFilmEntry>>> {
        return runner.mapperForResponse(resultsMapper) {
            douban.inTheaters(page, pageSize).fetchBodyWithRetry().subjects
        }
    }
}