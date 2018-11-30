package com.movies.core.inject

import com.movies.core.initializers.EmojiInitializer
import com.movies.core.initializers.Initializer
import com.movies.core.initializers.RxAndroidInitializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

/**
 * @author donnieSky
 * @created_at 2018/11/28.
 * @description
 * @version
 */
@Module
abstract class InitializerModule {

    @Binds
    @IntoSet
    abstract fun provideEmojiInitializer(initializer: EmojiInitializer): Initializer

    @Binds
    @IntoSet
    abstract fun provideRxAndroidInitializer(initializer: RxAndroidInitializer): Initializer


}