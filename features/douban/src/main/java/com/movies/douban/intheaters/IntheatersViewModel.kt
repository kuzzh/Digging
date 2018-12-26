package com.movies.douban.intheaters

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.movies.data.entities.Video
import com.movies.data.interactors.UpdateIntheaters
import com.movies.data.interactors.launchInteractor
import com.movies.douqi.utils.AppViewModel
import io.reactivex.BackpressureStrategy
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
class IntheatersViewModel @Inject constructor(
        private val interactor: UpdateIntheaters
) : AppViewModel() {

    private val TAG = IntheatersViewModel::class.simpleName

    private val pageListConfig = PagedList.Config.Builder().run {
        setPageSize(20 * 3)
        setPrefetchDistance(20)
        setEnablePlaceholders(false)
        build()
    }

    val dataSource = LiveDataReactiveStreams.fromPublisher(
            RxPagedListBuilder<Int, Video>(interactor.dataSourceFactory(),
                    pageListConfig)
                    .setBoundaryCallback(object : PagedList.BoundaryCallback<Video>() {
                        override fun onItemAtEndLoaded(itemAtEnd: Video) {
                            onListScrollToEnd()
                        }
                    }).buildFlowable(BackpressureStrategy.LATEST)
                    .distinctUntilChanged()
    )

    init {
        refresh()
    }

    fun refresh() {
        scope.launch {
            try {
                launchInteractor(interactor, UpdateIntheaters.Params(UpdateIntheaters.Page.REFRESH)).join()
            } catch (e: Exception) {
                Timber.tag(TAG).e(e)
            }
        }
    }

    fun onListScrollToEnd() {
        scope.launch {
            try {
                launchInteractor(interactor, UpdateIntheaters.Params(UpdateIntheaters.Page.NEXT_PAGE)).join()
            } catch (e: Exception) {
                Timber.tag(TAG).e(e)
            }
        }
    }

}