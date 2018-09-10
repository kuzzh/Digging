package com.movies.douqi.ui.douban

import com.movies.data.resultentities.InTheaterEntryWithFilm
import com.movies.douqi.utils.EntryViewModel
import com.movies.interactors.UpdateInTheaterFilms
import com.movies.utils.AppCoroutineDispatchers
import com.movies.utils.AppRxSchedulers
import com.movies.utils.Logger
import kotlinx.coroutines.experimental.withContext
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
class InTheatersViewModel @Inject constructor(
        schedulers: AppRxSchedulers,
        dispatchers: AppCoroutineDispatchers,
        private val interactor: UpdateInTheaterFilms,
        val logger: Logger
) : EntryViewModel<InTheaterEntryWithFilm>(
        schedulers,
        dispatchers,
        interactor.dataSourceFactory(),
        logger
) {

    fun onItemClicked() {
        logger.d("grid item clicked !")
    }

    override suspend fun callRefresh() {
        withContext(interactor.dispatcher) {
            interactor(UpdateInTheaterFilms.ExecuteParams(UpdateInTheaterFilms.Page.REFRESH))
        }
    }

    override suspend fun callLoadMore() {
        withContext(interactor.dispatcher) {
            interactor(UpdateInTheaterFilms.ExecuteParams(UpdateInTheaterFilms.Page.NEXT_PAGE))
        }
    }

}