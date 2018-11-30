package com.movies.douqi.utils

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
open class AppViewModel : ViewModel(), IViewModel {

    private val job = Job()

    override val disposable = CompositeDisposable()
    override val scope = CoroutineScope(Dispatchers.Main + job)

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
        job.cancel()
    }
}