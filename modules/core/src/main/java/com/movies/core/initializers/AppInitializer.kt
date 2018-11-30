package com.movies.core.initializers

import android.app.Application
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/28.
 * @description
 * @version
 */
class AppInitializer @Inject constructor(
        private val initializers: Set<@JvmSuppressWildcards Initializer>
) {
    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}