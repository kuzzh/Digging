package com.movies.douqi.ui.detail

import androidx.lifecycle.ViewModel
import com.movies.douqi.inject.ViewModelKey
import com.movies.douqi.ui.dytt.DyttFragment
import com.movies.douqi.ui.dytt.DyttViewModel
import com.movies.douqi.ui.mahua.MahuaViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author donnieSky
 * @created_at 2018/9/3.
 * @description
 * @version
 */
@Module
abstract class MovieDetailModule {

    @ContributesAndroidInjector
    internal abstract fun buildDyttFragment(): DyttFragment

    @Binds
    @IntoMap
    @ViewModelKey(DyttViewModel::class)
    abstract fun bindDyttViewModel(viewModel: DyttViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MahuaViewModel::class)
    abstract fun bindMahuaViewModel(viewModel: MahuaViewModel): ViewModel

}