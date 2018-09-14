package com.movies.douqi.utils

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.movies.douqi.BuildConfig
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.experimental.Job

/**
 * @author donnieSky
 * @created_at 2018/9/13.
 * @description
 * @version
 */
open class DouqiMvRxViewModel<S : MvRxState>(
        initialState: S
) : BaseMvRxViewModel<S>(initialState, debugMode = BuildConfig.DEBUG), IViewModel {
    override val viewModelJob = Job()
    override val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
        viewModelJob.cancel()
    }
}