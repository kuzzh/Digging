package com.movies.core.extensions

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope


/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
suspend fun <A, B> Collection<A>.parallelForEach(
        block: suspend (A) -> B
) = coroutineScope {
    map {
        async { block(it) }
    }.forEach {
        it.await()
    }
}