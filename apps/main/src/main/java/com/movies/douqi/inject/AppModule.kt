package com.movies.douqi.inject

import android.content.Context
import com.movies.core.inject.InitializerModule
import com.movies.core.utils.AppCoroutineDispatchers
import com.movies.core.utils.AppRxSchedulers
import com.movies.douqi.App
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.rx2.asCoroutineDispatcher
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
@Module(includes = [InitializerModule::class])
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
    fun provideCoroutineDispatches(schedulers: AppRxSchedulers) = AppCoroutineDispatchers(
            io = schedulers.io.asCoroutineDispatcher(),
            computation = schedulers.computation.asCoroutineDispatcher(),
            main = Dispatchers.Main
    )
}