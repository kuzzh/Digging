package com.movies.douban.repositories

import com.movies.douban.entities.DBSubjectResult
import com.movies.douban.services.DouBanApi
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Singleton
class RemoteDoubanSource @Inject constructor(
        private val api: DouBanApi
) {
    fun inTheaters(): Flowable<DBSubjectResult> {
        return api.inTheaters(1, 50)
    }
}