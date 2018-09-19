package com.movies.douqi.inject

import com.movies.douqi.initializers.*
import com.movies.utils.Logger
import com.movies.utils.TimberLogger
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
@Module
abstract class InitializerModule {

    @Singleton
    @Binds
    abstract fun provideLogger(logger: TimberLogger): Logger

    @Binds
    @IntoSet
    abstract fun provideEmojiInitializer(initializer: EmojiInitializer): Initializer

    @Binds
    @IntoSet
    abstract fun provideRxAndroidInitializer(initializer: RxAndroidInitializer): Initializer

    @Binds
    @IntoSet
    abstract fun provideTimberInitializer(initializer: TimberInitializer): Initializer

    @Binds
    @IntoSet
    abstract fun provideExoPlayerInitializer(initializer: ExoPlayerInitializer): Initializer

}