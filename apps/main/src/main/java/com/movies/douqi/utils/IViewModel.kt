package com.movies.douqi.utils

import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
interface IViewModel {

    val disposable: CompositeDisposable

    val scope: CoroutineScope

}