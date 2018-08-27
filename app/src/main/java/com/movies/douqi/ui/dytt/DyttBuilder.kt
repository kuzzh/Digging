package com.movies.douqi.ui.dytt

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
internal abstract class DyttBuilder {

    @ContributesAndroidInjector
    internal abstract fun buildDyttFragment(): DyttFragment

    @Binds
    @IntoMap
    @ViewModelKey(DyttViewModel::class)
    abstract fun bindDyttViewModel(viewModel: DyttViewModel): ViewModel

}