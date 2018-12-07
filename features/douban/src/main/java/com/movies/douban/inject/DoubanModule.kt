package com.movies.douban.inject

import android.content.Context
import com.movies.douban.DoubanFragment
import dagger.Module
import dagger.Provides

/**
 * @author donnieSky
 * @created_at 2018/12/6.
 * @description
 * @version
 */
@Module
class DoubanModule {

    @Provides
    fun provideDoubanContext(doubanFragment: DoubanFragment): Context = doubanFragment.context!!

}