package com.movies.douqi.ui.main

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Module
abstract class MainModule {

    @Binds
    abstract fun provideMainActivity(activity: MainActivity): AppCompatActivity

}