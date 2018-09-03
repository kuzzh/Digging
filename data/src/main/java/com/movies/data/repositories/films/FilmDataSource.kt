package com.movies.data.repositories.films

import com.movies.data.entities.Result
import com.movies.douban.entities.DBSubjectResult

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
interface FilmDataSource {
    suspend fun inTheaters(): Result<DBSubjectResult>
}