package com.movies.douqi

import com.movies.douqi.initializers.AppInitializers
import com.movies.douqi.inject.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/8/22.
 * @description
 * @version
 */
class App : DaggerApplication() {

    @Inject
    lateinit var initializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        initializers.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}