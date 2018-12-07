package com.movies.data.interactors

import com.movies.core.Result
import com.movies.core.utils.AppCoroutineDispatchers
import com.movies.core.utils.AppRxSchedulers
import com.movies.data.entities.Video
import com.movies.data.repositories.intheaters.IntheatersRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
class UpdateIntheaters @Inject constructor(
        dispatchers: AppCoroutineDispatchers,
        private val schedulers: AppRxSchedulers,
        private val repository: IntheatersRepository
) : Interactor<UpdateIntheaters.Params> {

    override val dispatcher: CoroutineDispatcher = dispatchers.io

    override suspend fun invoke(param: Params) {
        when (param.page) {
            Page.REFRESH -> repository.refresh()
            Page.NEXT_PAGE -> repository.loadNextPage()
        }
    }

    suspend fun intheaters(): Result<List<Video>> {
        return repository.intheaters()
    }

    data class Params(val page: Page)

    enum class Page {
        REFRESH,
        NEXT_PAGE
    }
}