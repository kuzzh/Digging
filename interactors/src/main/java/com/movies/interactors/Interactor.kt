package com.movies.interactors

import androidx.paging.DataSource
import kotlinx.coroutines.experimental.CoroutineDispatcher

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
interface Interactor<in P> {
    val dispatcher: CoroutineDispatcher
    suspend operator fun invoke(params: P)
}

interface PagingInteractor<T> {
    fun dataSourceFactory(): DataSource.Factory<Int, T>
}