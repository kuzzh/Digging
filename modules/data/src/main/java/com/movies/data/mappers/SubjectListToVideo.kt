package com.movies.data.mappers

import com.movies.core.douban.entities.SubjectResponse
import com.movies.data.entities.Video
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
@Singleton
class SubjectListToVideo @Inject constructor(
        private val mapper: SubjectToVideo
) : Mapper<SubjectResponse, List<Video>> {
    override fun map(from: SubjectResponse?): List<Video>? {
        return from?.subjects?.map(mapper::map)
    }
}