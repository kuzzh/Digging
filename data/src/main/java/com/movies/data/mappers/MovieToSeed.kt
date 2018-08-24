package com.movies.data.mappers

import com.movies.data.entities.Seed
import com.movies.dytt.entities.Movie
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Singleton
class MovieToSeed @Inject constructor() : Mapper<Movie, Seed> {
    override fun map(from: Movie) = Seed(
            movieId = 0,
            id = from.id,
            categoryId = from.categoryId,
            name = from.name,
            publishTime = from.publishTime,
            homePicUrl = from.homePicUrl,
            content = from.content,
            pics = from.pics,
            downloadUrl = from.downloadUrl
    )
}