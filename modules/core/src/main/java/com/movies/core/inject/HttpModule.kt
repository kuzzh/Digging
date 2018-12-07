package com.movies.core.inject

import com.movies.core.DOUBAN
import com.movies.core.douban.interceptors.DoubanInterceptor
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/11/28.
 * @description
 * @version
 */
@Module
class HttpModule {

    @Singleton
    @Provides
    @IntoSet
    fun provideHttpLogger(): Interceptor = HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger { message ->
                Timber.tag("Okhttp").d(message)
            }).setLevel(HttpLoggingInterceptor.Level.BODY)

    @DOUBAN
    @Provides
    @Singleton
    fun provideDoubanRetrofit(@DOUBAN client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.douban.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    @DOUBAN
    @Provides
    @Singleton
    fun provideDoubanClient(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addNetworkInterceptor(DoubanInterceptor())
        interceptors.forEach {
            builder.addNetworkInterceptor(it)
        }
        return builder.build()
    }

}