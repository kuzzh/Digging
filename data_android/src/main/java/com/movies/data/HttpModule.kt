package com.movies.data

import com.movies.douban.Douban
import com.movies.dytt.interceptors.DyttInterceptor
import com.movies.inject.DOUBAN
import com.movies.inject.DYTT
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/27.
 * @description
 * @version
 */
@Module
class HttpModule {

    @DYTT
    @Provides
    @Singleton
    fun provideDYTTRetrofit(@DYTT client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl("http://m.dydytt.net:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    @DYTT
    @Provides
    @Singleton
    fun provideDYTTClient(
            interceptors: Set<@JvmSuppressWildcards Interceptor>
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addNetworkInterceptor(DyttInterceptor())
        interceptors.forEach {
            builder.addNetworkInterceptor(it)
        }
        return builder.build()
    }

    @DOUBAN
    @Provides
    @Singleton
    fun provideDoubanRetrofit(@DOUBAN client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(Douban.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    @DOUBAN
    @Provides
    @Singleton
    fun provideDoubanClient(
            interceptors: Set<@JvmSuppressWildcards Interceptor>
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        interceptors.forEach {
            builder.addNetworkInterceptor(it)
        }
        return builder.build()
    }

}