package com.movies.douban.inject

import com.movies.core.inject.CoreModule
import com.movies.core.inject.ViewModelModule
import com.movies.data.inject.DataModule
import com.movies.data.inject.DatabaseModule
import com.movies.douban.DoubanFragment
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/11/30.
 * @description
 * @version
 */
@Singleton
@Component(
        modules = [
            CoreModule::class,
            DataModule::class,
            DatabaseModule::class,
            DoubanModule::class,
            FragmentModule::class,
            ViewModelModule::class,
            AndroidSupportInjectionModule::class
        ]
)
interface DoubanComponent : AndroidInjector<DoubanFragment> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DoubanFragment>()

}