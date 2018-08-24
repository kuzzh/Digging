package com.movies.utils

import io.reactivex.Observable
import io.reactivex.Single

/**
 * @author donnieSky
 * @created_at 2018/8/21.
 * @description
 * @version
 */
interface NetworkDetector {
    fun observe(): Observable<Boolean>
    fun waitForConnection(): Single<Boolean>
}