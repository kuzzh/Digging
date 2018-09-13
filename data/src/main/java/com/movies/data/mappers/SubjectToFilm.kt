package com.movies.data.mappers

import com.movies.data.entities.Film
import com.movies.douban.entities.Subject
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Singleton
class SubjectToFilm @Inject constructor() : Mapper<Subject, Film> {
    override fun map(from: Subject) = Film(
            doubanId = from.id,
            title = from.title,
            originalTitle = from.originalTitle,
            summary = from.summary,
            subType = from.subType,
            year = from.year,
            alt = from.alt,
            ratingsCount = from.rating?.average,
            images = from.images.medium
    )
}