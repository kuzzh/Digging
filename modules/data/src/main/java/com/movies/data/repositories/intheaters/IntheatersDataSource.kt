package com.movies.data.repositories.intheaters

import com.movies.core.Result
import com.movies.data.entities.Video

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
interface IntheatersDataSource {
    suspend fun inTheaters(start: Int, count: Int): Result<List<Video>>
}