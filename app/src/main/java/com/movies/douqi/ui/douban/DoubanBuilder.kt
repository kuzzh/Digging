package com.movies.douqi.ui.douban

import androidx.lifecycle.ViewModel
import com.movies.douqi.inject.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author donnieSky
 * @created_at 2018/8/27.
 * @description
 * @version
 */
@Module
internal abstract class DoubanBuilder {

    @ContributesAndroidInjector
    internal abstract fun buildDoubanFragment(): DoubanFragment

    @Binds
    @IntoMap
    @ViewModelKey(DoubanViewModel::class)
    abstract fun bindDoubanViewModel(viewModel: DoubanViewModel): ViewModel

}