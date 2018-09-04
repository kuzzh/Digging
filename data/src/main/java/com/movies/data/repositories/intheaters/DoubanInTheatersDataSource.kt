package com.movies.data.repositories.intheaters

import com.movies.data.RetrofitRunner
import com.movies.data.entities.Result
import com.movies.douban.entities.DBSubjectResult
import com.movies.douban.services.DoubanService
import com.movies.extensions.executeWithRetry
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
class DoubanInTheatersDataSource @Inject constructor(
        private val douban: DoubanService,
        private val runner: RetrofitRunner
) : InTheatersDataSource {
    override suspend fun getInTheaters(page: Int, pageSize: Int): Result<DBSubjectResult> {
        return runner.executeForResponse {
            douban.inTheaters(page, pageSize).executeWithRetry()
        }
    }
}