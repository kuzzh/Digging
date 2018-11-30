package com.movies.data.interactors

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
interface Interactor<in P> {
    val dispatcher: CoroutineDispatcher
    suspend operator fun invoke(param: P)
}