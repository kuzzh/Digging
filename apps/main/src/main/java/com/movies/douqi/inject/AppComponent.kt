package com.movies.douqi.inject

import com.movies.core.inject.CoreModule
import com.movies.core.inject.ViewModelModule
import com.movies.data.inject.DataModule
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
    CoreModule::class,
    DataModule::class,
    DatabaseModule::class,
    ViewModelModule::class,
    ActivityBindingModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}