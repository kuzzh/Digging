package com.movies.interactors

import androidx.paging.DataSource
import com.movies.data.repositories.intheaters.InTheatersRepository
import com.movies.data.resultentities.InTheaterEntryWithFilm
import com.movies.extensions.emptyFlowableList
import com.movies.utils.AppCoroutineDispatchers
import com.movies.utils.AppRxSchedulers
import io.reactivex.Flowable
import kotlinx.coroutines.experimental.CoroutineDispatcher
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
class UpdateInTheaterFilms @Inject constructor(
        private val dispatchers: AppCoroutineDispatchers,
        private val schedulers: AppRxSchedulers,
        private val repository: InTheatersRepository
) : PagingInteractor<InTheaterEntryWithFilm>, SubjectInteractor<Unit, UpdateInTheaterFilms.ExecuteParams, List<InTheaterEntryWithFilm>>() {
    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override fun dataSourceFactory(): DataSource.Factory<Int, InTheaterEntryWithFilm> {
        return repository.observeForPaging()
    }

    override suspend fun execute(params: Unit, executeParams: ExecuteParams) {
        when (executeParams.page) {
            Page.NEXT_PAGE -> repository.loadNextPage()
            Page.REFRESH -> repository.refresh()
        }
    }

    override fun createObservable(params: Unit): Flowable<List<InTheaterEntryWithFilm>> {
        return repository.observeForFlowable()
                .startWith(emptyFlowableList())
                .subscribeOn(schedulers.io)
    }

    data class ExecuteParams(val page: Page)

    enum class Page {
        NEXT_PAGE, REFRESH
    }

}