package com.movies.data.repositories

import com.movies.douban.repositories.DoubanRepository
import com.movies.dytt.repositories.DyttRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Singleton
class Repository @Inject constructor(
        val douban: DoubanRepository,
        val dytt: DyttRepository
)