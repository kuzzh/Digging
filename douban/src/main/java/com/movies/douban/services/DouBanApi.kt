package com.movies.douban.services

import com.movies.douban.entities.DBListResult
import com.movies.douban.entities.Subject
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
interface DouBanApi {

    /**
     * 正在上映的电影
     */
    @GET("v2/movie/in_theaters")
    fun inTheaters(): Flowable<DBListResult<Subject>>

    /**
     * 即将上映的电影
     */
    @GET("v2/movie/coming_soon")
    fun comingSoon(): Flowable<DBListResult<Subject>>

    /**
     * top250的电影
     */
    @GET("v2/movie/top250")
    fun top250(): Flowable<DBListResult<Subject>>

    /**
     * 口碑榜
     */
    @GET("v2/movie/weekly")
    fun weekly(): Flowable<DBListResult<Subject>>

    /**
     * 北美票房榜
     */
    @GET("v2/movie/us_box")
    fun usBox(): Flowable<DBListResult<Subject>>

    /**
     * 新片榜
     */
    @GET("v2/movie/new_movies")
    fun newMovies(): Flowable<DBListResult<Subject>>

    /**
     * 影片详情
     */
    @GET("/v2/movie/subject/{subjectId}")
    fun getSubjectDetail(@Path("subjectId") id: String): Flowable<Subject>

}