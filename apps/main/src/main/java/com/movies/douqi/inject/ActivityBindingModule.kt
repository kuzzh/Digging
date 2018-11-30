package com.movies.douqi.inject

import com.movies.douqi.main.MainActivity
import com.movies.douqi.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author donnieSky
 * @created_at 2018/11/30.
 * @description
 * @version
 */
@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity

}