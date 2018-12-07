package com.movies.core.inject

import com.movies.core.utils.AppCoroutineDispatchers
import com.movies.core.utils.AppRxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.rx2.asCoroutineDispatcher

/**
 * @author donnieSky
 * @created_at 2018/11/30.
 * @description
 * @version
 */
@Module(includes = [
    ApiModule::class,
    HttpModule::class
])
class CoreModule {

    @Provides
    fun provideRxSchedulers(): AppRxSchedulers = AppRxSchedulers(
            io = Schedulers.io(),
            computation = Schedulers.computation(),
            main = AndroidSchedulers.mainThread()
    )

    @Provides
    fun provideCoroutineDispatches(schedulers: AppRxSchedulers) = AppCoroutineDispatchers(
            io = schedulers.io.asCoroutineDispatcher(),
            computation = schedulers.computation.asCoroutineDispatcher(),
            main = Dispatchers.Main
    )

}