package com.movies.douban.intheaters

import androidx.lifecycle.ViewModel
import com.movies.core.inject.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
@Module
abstract class IntheatersModule {

    @Binds
    @IntoMap
    @ViewModelKey(IntheatersViewModel::class)
    abstract fun bindIntheatersViewModel(viewModel: IntheatersViewModel): ViewModel

}