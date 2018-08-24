package com.movies.douqi.initializers

import android.app.Application
import com.movies.douqi.BuildConfig
import com.movies.utils.TimberLogger
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
class TimberInitializer @Inject constructor(
        private val timberLogger: TimberLogger
) : Initializer {
    override fun init(application: Application) {
        timberLogger.setup(BuildConfig.DEBUG)
    }
}