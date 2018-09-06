package com.movies.douqi.utils

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.movies.data.Entry
import com.movies.data.resultentities.EntryWithFilm
import com.movies.douqi.base.BaseViewModel
import com.movies.douqi.extensions.distinctUntilChanged
import com.movies.extensions.toFlowable
import com.movies.utils.AppCoroutineDispatchers
import com.movies.utils.AppRxSchedulers
import com.movies.utils.Logger
import io.reactivex.subjects.BehaviorSubject

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
abstract class EntryViewModel<LI : EntryWithFilm<out Entry>>(
        private val schedulers: AppRxSchedulers,
        private val dispatchers: AppCoroutineDispatchers,
        private val dataSource: DataSource.Factory<Int, LI>,
        private val logger: Logger,
        private val pageSize: Int = 21
) : BaseViewModel() {

    init {
        refresh()
    }

    private val messages = BehaviorSubject.create<UiResource>()

    val viewState = LiveDataReactiveStreams.fromPublisher(messages.toFlowable())

    val liveList by lazy(mode = LazyThreadSafetyMode.NONE) {
        LivePagedListBuilder<Int, LI>(
                dataSource,
                PagedList.Config.Builder().run {
                    setPageSize(pageSize * 3)
                    setPrefetchDistance(pageSize)
                    setEnablePlaceholders(false)
                    build()
                }
        ).setBoundaryCallback(object : PagedList.BoundaryCallback<LI>() {
            override fun onItemAtEndLoaded(itemAtEnd: LI) {
                onListScrolledToEnd()
            }
        }).build().distinctUntilChanged()
    }

    fun onListScrolledToEnd() {
        launchWithParent(dispatchers.main) {
            sendMessage(UiResource(Status.LOADING_MORE))
            try {
                callLoadMore()
                onSuccess()
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    fun refresh() {
        launchWithParent(dispatchers.main) {
            sendMessage(UiResource(Status.REFRESHING))
            try {
                callRefresh()
                onSuccess()
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    protected open suspend fun callRefresh() = Unit

    protected open suspend fun callLoadMore() = Unit

    private fun onError(t: Throwable) {
        logger.e(t)
        sendMessage(UiResource(Status.ERROR, t.localizedMessage))
    }

    private fun onSuccess() {
        sendMessage(UiResource(Status.SUCCESS))
    }

    private fun sendMessage(uiResource: UiResource) {
        messages.onNext(uiResource)
    }
}