package com.movies.douban.repositories

import com.movies.douban.entities.DBSubjectResult
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
class DoubanRepository @Inject constructor(
        private val local: LocalDoubanSource,
        private val remote: RemoteDoubanSource
) {
    fun inTheaters(): Flowable<DBSubjectResult> {
        return remote.inTheaters()
    }
}