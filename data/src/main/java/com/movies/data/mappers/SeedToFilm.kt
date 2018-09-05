package com.movies.data.mappers

import com.movies.data.entities.Film
import com.movies.dytt.entities.Seed
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
@Singleton
class SeedToFilm @Inject constructor() : Mapper<Seed, Film> {
    override fun map(from: Seed) = Film(
            dyttId = from.id,
            downloadUrl = from.downloadUrl
    )
}