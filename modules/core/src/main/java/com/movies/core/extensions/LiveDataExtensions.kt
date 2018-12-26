package com.movies.core.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * @author donnieSky
 * @created_at 2018/12/26.
 * @description
 * @version
 */
inline fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner,
                                          crossinline observer: (T) -> Unit) {
    this.observe(owner, Observer { it?.run(observer) })
}