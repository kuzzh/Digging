package com.movies.douban.inject

import com.movies.douban.DoubanFragment
import com.movies.douban.intheaters.IntheatersFragment
import com.movies.douban.intheaters.IntheatersModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author donnieSky
 * @created_at 2018/12/6.
 * @description
 * @version
 */
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindDoubanFragment(): DoubanFragment

    @ContributesAndroidInjector(modules = [IntheatersModule::class])
    abstract fun bindIntheatersFragment(): IntheatersFragment

}