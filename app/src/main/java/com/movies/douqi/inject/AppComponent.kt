package com.movies.douqi.inject

import com.movies.data.ApiModule
import com.movies.data.HttpModule
import com.movies.douqi.App
import com.movies.douqi.ui.detail.MovieDetailBuilder
import com.movies.douqi.ui.main.MainBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    InterceptorModule::class,
    ViewModelModule::class,
    ApiModule::class, HttpModule::class,
    AppModule::class, MainBuilder::class,
    MovieDetailBuilder::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}