package com.movies.data.mappers

import com.movies.core.douban.entities.Subject
import com.movies.data.entities.From
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
class SubjectToVideo @Inject constructor() : Mapper<Subject, Video> {
    override fun map(from: Subject?) = Video(
            from = From.DOUBAN.from,
            fromId = from?.id,
            title = from?.title,
            summary = from?.summary,
            picture = from?.images?.medium,
            rating = from?.rating?.average
    )
}