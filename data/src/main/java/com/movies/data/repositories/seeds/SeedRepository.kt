package com.movies.data.repositories.seeds

import com.movies.data.entities.Result
import com.movies.dytt.entities.Seed
import com.movies.mahua.entities.Video

/**
 * @author donnieSky
 * @created_at 2018/9/13.
 * @description
 * @version
 */
interface SeedRepository {
    suspend fun searchFilmByDytt(content: String, page: Int): Result<List<Seed>>
    suspend fun searchFilmByMahua(content: String, page: Int, pageSize: Int): Result<List<Video>>
    suspend fun getFilmByDytt(categoryId: Int, movieId: Long): Result<Seed>
    suspend fun getFilmByMahua(videoId: Long): Result<Video>
}