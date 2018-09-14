package com.movies.interactors

import androidx.paging.DataSource
import com.movies.extensions.toFlowable
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.coroutines.experimental.CoroutineDispatcher

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
interface Interactor<in P> {
    val dispatcher: CoroutineDispatcher
    suspend operator fun invoke(executeParams: P)
}

abstract class Motion<EP, T> {
    private var disposable: Disposable? = null
    private val subject: BehaviorSubject<T> = BehaviorSubject.create()

    val loading = BehaviorSubject.createDefault(false)

    suspend operator fun invoke(executeParams: EP) {
        try {
            loading.onNext(true)
            setSource(execute(executeParams))
            loading.onNext(false)
        } catch (t: Throwable) {
            loading.onError(t)
        }
    }

    protected abstract suspend fun execute(executeParams: EP): Flowable<T>

    fun observe(): Flowable<T> = subject.toFlowable()

    private fun setSource(source: Flowable<T>) {
        disposable?.dispose()
        disposable = source.subscribe(subject::onNext, subject::onError)
    }

    fun clear() {
        disposable?.dispose()
        disposable = null
    }
}

interface PagingInteractor<T> {
    fun dataSourceFactory(): DataSource.Factory<Int, T>
}

abstract class SubjectInteractor<P : Any, EP, T> : Interactor<EP> {
    private var disposable: Disposable? = null
    private val subject: BehaviorSubject<T> = BehaviorSubject.create()

    val loading = BehaviorSubject.createDefault(false)

    private lateinit var params: P

    fun setParams(params: P) {
        this.params = params
        setSource(createObservable(params))
    }

    final override suspend fun invoke(executeParams: EP) {
        try {
            loading.onNext(true)
            execute(params, executeParams)
            loading.onNext(false)
        } catch (t: Throwable) {
            loading.onError(t)
        }
    }

    protected abstract suspend fun execute(params: P, executeParams: EP)

    protected abstract fun createObservable(params: P): Flowable<T>

    fun clear() {
        disposable?.dispose()
        disposable = null
    }

    fun observe(): Flowable<T> = subject.toFlowable()

    private fun setSource(source: Flowable<T>) {
        disposable?.dispose()
        disposable = source.subscribe(subject::onNext, subject::onError)
    }
}