package com.movies.core.initializers

import android.app.Application
import android.os.Looper
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/28.
 * @description
 * @version
 */
class RxAndroidInitializer @Inject constructor() : Initializer {
    override fun init(application: Application) {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            AndroidSchedulers.from(Looper.getMainLooper(), true)
        }
    }
}