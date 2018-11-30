package com.movies.core.inject

import com.movies.core.DOUBAN
import com.movies.core.douban.api.DoubanService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/11/28.
 * @description
 * @version
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideDoubanApi(@DOUBAN retrofit: Retrofit): DoubanService {
        return retrofit.create(DoubanService::class.java)
    }

}