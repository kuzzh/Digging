package com.movies.mahua.repositories

import com.google.gson.Gson
import com.movies.mahua.entities.BodyParams
import com.movies.mahua.entities.DataParam
import com.movies.mahua.entities.VideoInfoResult
import com.movies.mahua.entities.VideosResult
import com.movies.mahua.services.MahuaApi
import com.movies.mahua.utils.AES
import io.reactivex.Flowable
import okhttp3.MediaType
import okhttp3.RequestBody
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/9/12.
 * @description
 * @version
 */
@Singleton
class MahuaRepository @Inject constructor(
        private val api: MahuaApi
) {

    fun searchVideo(content: String,
                    currentPage: Int): Flowable<VideosResult> {
        val params = BodyParams(
                searchContent = content,
                currentPage = currentPage,
                pageSize = 20,
                entry = 1
        )

        val encrypt = AES.encryptToHex(Gson().toJson(params), false)
        val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), encrypt)

        return api.searchVideo(body)
    }

    fun getVideoInfo(videoId: Long): Flowable<VideoInfoResult> {
        val params = BodyParams(data = DataParam(videoInfoId = videoId), columnId = 0)
        val encrypt = AES.encryptToHex(Gson().toJson(params), false)
        val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), encrypt)
        return api.getVideoDetail(body)
    }

}