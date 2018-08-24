package com.movies.utils

import com.movies.extensions.toFlowable
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * @author donnieSky
 * @created_at 2018/8/21.
 * @description
 * @version
 */
class RxLoadingCounter {

    private var loaders = 0
    private val loadingState = BehaviorSubject.createDefault(loaders)

    val observable: Observable<Boolean>
        get() = loadingState.map { it > 0 }

    val flowable by lazy(LazyThreadSafetyMode.NONE) { observable.toFlowable() }

    fun addLoader() {
        loadingState.onNext(++loaders)
    }

    fun removeLoader() {
        loadingState.onNext(--loaders)
    }
}