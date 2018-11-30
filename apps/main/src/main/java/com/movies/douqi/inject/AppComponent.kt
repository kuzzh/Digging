package com.movies.douqi.inject

import com.movies.core.inject.ApiModule
import com.movies.core.inject.HttpModule
import com.movies.core.inject.ViewModelModule
import com.movies.data.inject.DatabaseModule
import com.movies.douqi.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
@Singleton
@Component(modules = [
    AppModule::class,
    HttpModule::class,
    ApiModule::class,
    DatabaseModule::class,
    ViewModelModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}