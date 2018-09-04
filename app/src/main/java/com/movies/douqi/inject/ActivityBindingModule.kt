package com.movies.douqi.inject

import com.movies.douqi.ui.detail.MovieDetailActivity
import com.movies.douqi.ui.detail.MovieDetailModule
import com.movies.douqi.ui.main.MainActivity
import com.movies.douqi.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
@Module
internal abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [
        MainModule::class
    ])
    internal abstract fun buildMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [MovieDetailModule::class])
    internal abstract fun buildMovieDetailActivity(): MovieDetailActivity

}