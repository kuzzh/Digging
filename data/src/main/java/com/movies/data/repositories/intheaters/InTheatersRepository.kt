package com.movies.data.repositories.intheaters

import com.movies.utils.AppCoroutineDispatchers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
@Singleton
class InTheatersRepository @Inject constructor(
        private val dispatchers: AppCoroutineDispatchers,
        private val dataSource: DoubanInTheatersDataSource
) {


}