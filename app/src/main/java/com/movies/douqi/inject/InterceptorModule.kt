package com.movies.douqi.inject

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Module
class InterceptorModule {

    @Singleton
    @Provides
    @IntoSet
    fun provideHttpLogger(): Interceptor = HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger { message ->
                Timber.d(message)
            }).setLevel(HttpLoggingInterceptor.Level.BODY)
}