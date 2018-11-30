package com.movies.core.douban.api

import com.movies.core.douban.entities.SubjectResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author donnieSky
 * @created_at 2018/11/26.
 * @description
 * @version
 */
interface DoubanService {

    @GET("v2/movie/in_theaters")
    fun inTheaters(@Query("start") start: Int,
                   @Query("count") count: Int): Deferred<Response<SubjectResponse>>

}