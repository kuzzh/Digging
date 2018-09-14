package com.movies.douqi.utils

import androidx.lifecycle.LiveDataReactiveStreams
import com.movies.douqi.base.BaseViewModel
import com.movies.extensions.toFlowable
import com.movies.utils.AppCoroutineDispatchers
import io.reactivex.subjects.BehaviorSubject

/**
 * @author donnieSky
 * @created_at 2018/9/13.
 * @description
 * @version
 */
abstract class SingleViewModel<T>(
        val dispatchers: AppCoroutineDispatchers
) : BaseViewModel() {

    private val messages = BehaviorSubject.create<UiResource>()

    val viewState = LiveDataReactiveStreams.fromPublisher(messages.toFlowable())


    fun onError(t: Throwable) {
        sendMessage(UiResource(Status.ERROR, t.localizedMessage))
    }

    fun onSuccess() {
        sendMessage(UiResource(Status.SUCCESS))
    }

    fun sendMessage(uiResource: UiResource) {
        messages.onNext(uiResource)
    }
}