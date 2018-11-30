package com.movies.douqi

import android.content.Context
import androidx.multidex.MultiDex
import com.movies.core.initializers.AppInitializer
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
    lateinit var initializers: AppInitializer

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        initializers.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}