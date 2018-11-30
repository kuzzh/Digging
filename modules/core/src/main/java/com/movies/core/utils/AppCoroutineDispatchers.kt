package com.movies.core.utils

import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
data class AppCoroutineDispatchers(
        val io: CoroutineDispatcher,
        val computation: CoroutineDispatcher,
        val main: CoroutineDispatcher
)