package com.movies.douqi.ui.main

import androidx.lifecycle.ViewModel
import com.movies.douqi.inject.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}