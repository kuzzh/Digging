package com.movies.data.repositories.intheaters

import com.movies.core.Result
import com.movies.core.douban.api.DoubanService
import com.movies.data.entities.Video
import com.movies.data.mappers.SubjectListToVideo
import com.movies.data.utils.RetrofitRunner
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
class RemoteIntheaters @Inject constructor(
        private val service: DoubanService,
        private val runner: RetrofitRunner,
        private val mapper: SubjectListToVideo
) : IntheatersDataSource {
    override suspend fun inTheaters(start: Int, count: Int): Result<List<Video>> {
        return runner.executeForResponse(mapper) {
            service.inTheaters(start, count)
        }
    }
}