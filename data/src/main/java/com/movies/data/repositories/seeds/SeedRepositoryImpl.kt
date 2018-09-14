package com.movies.data.repositories.seeds

import com.google.gson.Gson
import com.movies.data.RetrofitRunner
import com.movies.data.entities.Result
import com.movies.data.mappers.SeedToSeed
import com.movies.data.mappers.VideoToSeed
import com.movies.data.mappers.toListMapper
import com.movies.dytt.entities.Seed
import com.movies.dytt.services.DYTTService
import com.movies.extensions.fetchBodyWithRetry
import com.movies.mahua.entities.BodyParams
import com.movies.mahua.entities.DataParam
import com.movies.mahua.entities.Video
import com.movies.mahua.services.MahuaService
import com.movies.mahua.utils.AES
import okhttp3.MediaType
import okhttp3.RequestBody
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/13.
 * @description
 * @version
 */
class SeedRepositoryImpl @Inject constructor(
        private val dyttApi: DYTTService,
        private val mahuaApi: MahuaService,
        private val runner: RetrofitRunner,
        private val seedMapper: SeedToSeed,
        private val videoMapper: VideoToSeed
) : SeedRepository {
    override suspend fun searchFilmByDytt(content: String, page: Int): Result<List<Seed>> {
        return runner.mapperForResponse(seedMapper.toListMapper()) {
            dyttApi.searchMovie(0, page, content).fetchBodyWithRetry().rows
        }
    }

    override suspend fun searchFilmByMahua(content: String, page: Int, pageSize: Int): Result<List<Video>> {
        val params = BodyParams(searchContent = content, currentPage = page, pageSize = pageSize, entry = 1)
        val encrypt = AES.encryptToHex(Gson().toJson(params), false)
        val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), encrypt)
        return runner.mapperForResponse(videoMapper.toListMapper()) {
            mahuaApi.searchVideo(body).fetchBodyWithRetry().data
        }
    }

    override suspend fun getFilmByDytt(categoryId: Int, movieId: Long): Result<Seed> {
        return runner.executeForResponse(seedMapper) {
            dyttApi.getMovieDetail(categoryId, movieId).execute()
        }
    }

    override suspend fun getFilmByMahua(videoId: Long): Result<Video> {
        val params = BodyParams(data = DataParam(videoInfoId = videoId), columnId = 0)
        val encrypt = AES.encryptToHex(Gson().toJson(params), false)
        val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), encrypt)
        return runner.mapperForResponse(videoMapper) {
            mahuaApi.getVideoDetail(body).fetchBodyWithRetry().data
        }
    }
}