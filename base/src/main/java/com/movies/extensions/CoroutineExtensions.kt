package com.movies.extensions

import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.async
import kotlin.coroutines.experimental.CoroutineContext

/**
 * @author donnieSky
 * @created_at 2018/9/6.
 * @description
 * @version
 */
suspend fun <A, B> Collection<A>.parallelMap(
        context: CoroutineContext = DefaultDispatcher,
        block: suspend (A) -> B
) = map {
    async(context) { block(it) }
}.map { it.await() }

suspend fun <A, B> Collection<A>.parallelForEach(
        context: CoroutineContext = DefaultDispatcher,
        block: suspend (A) -> B
) = map {
    async(context) { block(it) }
}.forEach { it.await() }