package com.movies.douqi.inject

import android.content.Context
import com.movies.core.inject.InitializerModule
import com.movies.douqi.App
import dagger.Module
import dagger.Provides
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
}