package com.movies.douqi.ui.main

import androidx.lifecycle.ViewModelProvider
import com.movies.douqi.inject.ViewModelFactory
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
    internal abstract fun bindMainViewModel(factory: ViewModelFactory): ViewModelProvider.Factory

}