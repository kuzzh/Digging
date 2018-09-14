package com.movies.data.mappers

import com.movies.mahua.entities.Video
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/9/14.
 * @description
 * @version
 */
@Singleton
class VideoToSeed @Inject constructor() : Mapper<Video, Video> {
    override fun map(from: Video) = from
}