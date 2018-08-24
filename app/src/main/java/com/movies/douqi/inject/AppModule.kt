package com.movies.douqi.inject

import android.content.Context
import com.movies.douqi.App
import com.movies.douqi.initializers.AppInitializers
import com.movies.douqi.initializers.EmojiInitializer
import com.movies.douqi.initializers.RxAndroidInitializer
import com.movies.douqi.initializers.TimberInitializer
import com.movies.utils.AppRxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Module(includes = [])
class AppModule {

    @Singleton
    @Provides
    fun provideApplicationContext(app: App): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideRxSchedulers(): AppRxSchedulers = AppRxSchedulers(
            io = Schedulers.io(),
            computation = Schedulers.computation(),
            main = AndroidSchedulers.mainThread()
    )

    @Singleton
    @Provides
    fun provideAppInitializers(
            rxAndroidInitializer: RxAndroidInitializer,
            timberInitializer: TimberInitializer,
            emojiInitializer: EmojiInitializer
    ) = AppInitializers(rxAndroidInitializer, timberInitializer, emojiInitializer)

    @Singleton
    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()
}