package com.movies.douqi.ui.detail

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author donnieSky
 * @created_at 2018/9/3.
 * @description
 * @version
 */
@Module
internal abstract class MovieDetailBuilder {

    @ContributesAndroidInjector(modules = [MovieDetailModule::class])
    internal abstract fun buildMovieDetailActivity(): MovieDetailActivity

}