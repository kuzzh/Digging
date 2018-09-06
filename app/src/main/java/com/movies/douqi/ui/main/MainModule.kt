package com.movies.douqi.ui.main

import androidx.lifecycle.ViewModel
import com.movies.douqi.inject.ViewModelKey
import com.movies.douqi.ui.douban.DoubanFragment
import com.movies.douqi.ui.douban.DoubanViewModel
import com.movies.douqi.ui.douban.InTheatersViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Module
abstract class MainModule {

    @ContributesAndroidInjector
    internal abstract fun buildDoubanFragment(): DoubanFragment

    @Binds
    @IntoMap
    @ViewModelKey(DoubanViewModel::class)
    abstract fun bindDoubanViewModel(viewModel: DoubanViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(InTheatersViewModel::class)
    abstract fun bindInTheaterViewModel(viewModel: InTheatersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}