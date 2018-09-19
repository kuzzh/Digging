package com.movies.douqi.ui.player

import androidx.lifecycle.ViewModel
import com.movies.douqi.inject.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author donnieSky
 * @created_at 2018/9/19.
 * @description
 * @version
 */
@Module
abstract class PlayerModule {

    @Binds
    @IntoMap
    @ViewModelKey(PlayerViewModel::class)
    abstract fun bindDoubanViewModel(viewModel: PlayerViewModel): ViewModel

}