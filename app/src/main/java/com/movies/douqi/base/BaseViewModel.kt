package com.movies.douqi.base

import androidx.lifecycle.ViewModel
import com.movies.douqi.utils.IViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.experimental.Job

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
open class BaseViewModel : ViewModel(), IViewModel {

    override val viewModelJob = Job()

    override val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
        viewModelJob.cancel()
    }

}