package com.movies.mahua.services

import com.movies.mahua.entities.BodyParams
import com.movies.mahua.entities.VideoInfoResult
import com.movies.mahua.entities.VideosResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author donnieSky
 * @created_at 2018/9/12.
 * @description
 * @version
 */
interface MahuaService {

    @POST("api/app/video/video/searchVideoInfo")
    fun searchVideo(@Body params: BodyParams): Call<VideosResult>

    @POST("api/app/video/v3/video/searchVideoInfoDetail_v3")
    fun getVideoDetail(@Body params: BodyParams): Call<VideoInfoResult>

}