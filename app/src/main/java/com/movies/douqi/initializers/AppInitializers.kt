package com.movies.douqi.initializers

import android.app.Application

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
class AppInitializers(
        private vararg val initializers: Initializer
) : Initializer {
    override fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}