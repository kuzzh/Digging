package com.movies.douqi.ui.tivi

import androidx.lifecycle.ViewModel
import com.movies.douqi.inject.ViewModelKey
import com.movies.douqi.ui.player.PlayerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author donnieSky
 * @created_at 2018/10/18.
 * @description
 * @version
 */
@Module
abstract class TiviPlayerModule {

    @Binds
    @IntoMap
    @ViewModelKey(PlayerViewModel::class)
    abstract fun bindDoubanViewModel(viewModel: PlayerViewModel): ViewModel

}