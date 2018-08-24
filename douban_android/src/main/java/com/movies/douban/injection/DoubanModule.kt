package com.movies.douban.injection

import com.movies.douban.BuildConfig
import com.movies.douban.services.DouBanApi
import com.movies.inject.Douban
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
 * @created_at 2018/8/23.
 * @description
 * @version
 */
@Module
class DoubanModule {

    @Provides
    @Singleton
    fun provideDoubanApi(@Douban retrofit: Retrofit): DouBanApi {
        return retrofit.create(DouBanApi::class.java)
    }

    @Douban
    @Provides
    @Singleton
    fun provideDoubanRetrofit(@Douban client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl(BuildConfig.API_DOUBAN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    @Douban
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