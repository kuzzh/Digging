package com.movies.douqi.inject

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * @author donnieSky
 * @created_at 2018/8/27.
 * @description
 * @version
 */
@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindMainViewModel(factory: ViewModelFactory): ViewModelProvider.Factory
}