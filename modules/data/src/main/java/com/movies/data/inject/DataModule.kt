package com.movies.data.inject

import com.movies.data.repositories.intheaters.IntheatersDataSource
import com.movies.data.repositories.intheaters.RemoteIntheaters
import dagger.Binds
import dagger.Module

/**
 * @author donnieSky
 * @created_at 2018/11/30.
 * @description
 * @version
 */
@Module
abstract class DataModule {

    @Binds
    abstract fun bind(intheaters: RemoteIntheaters): IntheatersDataSource

}