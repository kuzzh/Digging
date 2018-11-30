package com.movies.douban.inject

import com.movies.core.FragmentScope
import com.movies.core.inject.ViewModelModule
import com.movies.douban.intheaters.IntheatersFragment
import com.movies.douban.intheaters.IntheatersModule
import com.movies.douqi.inject.AppComponent
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * @author donnieSky
 * @created_at 2018/11/30.
 * @description
 * @version
 */
@FragmentScope
@Component(
        modules = [
            IntheatersModule::class,
            ViewModelModule::class,
            AndroidSupportInjectionModule::class
        ],
        dependencies = [AppComponent::class]
)
interface IntheatersComponent : AndroidInjector<IntheatersFragment> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<IntheatersFragment>() {
        abstract fun app(component: AppComponent): Builder
    }

}