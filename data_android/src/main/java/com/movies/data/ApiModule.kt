package com.movies.data

import com.movies.douban.services.DouBanApi
import com.movies.douban.services.DoubanService
import com.movies.dytt.services.DYTTApi
import com.movies.dytt.services.DYTTService
import com.movies.inject.DOUBAN
import com.movies.inject.DYTT
import com.movies.inject.MAHUA
import com.movies.mahua.services.MahuaApi
import com.movies.mahua.services.MahuaService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/27.
 * @description
 * @version
 */
@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideDoubanApi(@DOUBAN retrofit: Retrofit): DouBanApi {
        return retrofit.create(DouBanApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDoubanService(@DOUBAN retrofit: Retrofit): DoubanService {
        return retrofit.create(DoubanService::class.java)
    }

    @Provides
    @Singleton
    fun provideDYTTApi(@DYTT retrofit: Retrofit): DYTTApi {
        return retrofit.create(DYTTApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDYTTService(@DYTT retrofit: Retrofit): DYTTService {
        return retrofit.create(DYTTService::class.java)
    }

    @Provides
    @Singleton
    fun provideMahuaApi(@MAHUA retrofit: Retrofit): MahuaApi {
        return retrofit.create(MahuaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMahuaService(@MAHUA retrofit: Retrofit): MahuaService {
        return retrofit.create(MahuaService::class.java)
    }
}