package com.movies.douqi.utils

import com.movies.interactors.Interactor
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
interface IViewModel {

    val viewModelJob: Job

    val disposables: CompositeDisposable

    fun launchWithParent(
            context: CoroutineContext = DefaultDispatcher,
            block: suspend CoroutineScope.() -> Unit
    ) = launch(context = context, parent = viewModelJob, block = block)

    fun <P> launchInteractor(interactor: Interactor<P>, param: P): Job {
        return launch(context = interactor.dispatcher, parent = viewModelJob, block = { interactor(param) })
    }

    fun launchInteractor(interactor: Interactor<Unit>): Job {
        return launch(context = interactor.dispatcher, parent = viewModelJob, block = { interactor(Unit) })
    }
}