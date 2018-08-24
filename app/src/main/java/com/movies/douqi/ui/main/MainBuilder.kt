package com.movies.douqi.ui.main

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

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun mainActivity(): MainActivity

}