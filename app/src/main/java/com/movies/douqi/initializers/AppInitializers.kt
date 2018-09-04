package com.movies.douqi.initializers

import android.app.Application
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
class AppInitializers @Inject constructor(
        private val initializers: Set<@JvmSuppressWildcards Initializer>
) {
    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}