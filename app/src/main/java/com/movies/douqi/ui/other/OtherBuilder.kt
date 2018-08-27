package com.movies.douqi.ui.other

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
internal abstract class OtherBuilder {

    @ContributesAndroidInjector
    internal abstract fun buildOtherFragment(): TestFragment

    @Binds
    @IntoMap
    @ViewModelKey(OtherViewModel::class)
    abstract fun bindOtherViewModel(viewModel: OtherViewModel): ViewModel

}