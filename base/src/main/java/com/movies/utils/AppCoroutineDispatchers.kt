package com.movies.utils

import kotlinx.coroutines.experimental.CoroutineDispatcher

/**
 * @author donnieSky
 * @created_at 2018/8/21.
 * @description
 * @version
 */
data class AppCoroutineDispatchers(
        val io: CoroutineDispatcher,
        val computation: CoroutineDispatcher,
        val main: CoroutineDispatcher
)