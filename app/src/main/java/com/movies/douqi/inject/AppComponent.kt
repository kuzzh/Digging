package com.movies.douqi.inject

import com.movies.data.DataModule
import com.movies.douban.injection.DoubanModule
import com.movies.douqi.App
import com.movies.douqi.ui.main.MainBuilder
import com.movies.dytt.injection.DYTTModule
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
    DoubanModule::class, DYTTModule::class,
    DataModule::class, InterceptorModule::class,
    AppModule::class, MainBuilder::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}