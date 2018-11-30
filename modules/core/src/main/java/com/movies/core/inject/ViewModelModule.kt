package com.movies.core.inject

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
abstract class ViewModelModule {
    @Binds
    abstract fun bindMainViewModel(factory: ViewModelFactory): ViewModelProvider.Factory
}