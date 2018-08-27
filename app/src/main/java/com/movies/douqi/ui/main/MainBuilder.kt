package com.movies.douqi.ui.main

import com.movies.douqi.ui.douban.DoubanBuilder
import com.movies.douqi.ui.dytt.DyttBuilder
import com.movies.douqi.ui.other.OtherBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Module
internal abstract class MainBuilder {

    @ContributesAndroidInjector(modules = [
        MainModule::class,
        DoubanBuilder::class,
        DyttBuilder::class,
        OtherBuilder::class
    ])
    internal abstract fun buildMainActivity(): MainActivity

}