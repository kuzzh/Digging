package com.movies.douban.services

import com.movies.douban.entities.*
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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
    fun inTheaters(@Query("start") start: Int,
                   @Query("count") count: Int): Flowable<DBSubjectResult>

    /**
     * 即将上映的电影
     */
    @GET("v2/movie/coming_soon")
    fun comingSoon(): Flowable<DBSubjectResult>

    /**
     * top250的电影
     */
    @GET("v2/movie/top250")
    fun top250(): Flowable<DBSubjectResult>

    /**
     * 口碑榜
     */
    @GET("v2/movie/weekly")
    fun weekly(): Flowable<DBSubjectResult>

    /**
     * 北美票房榜
     */
    @GET("v2/movie/us_box")
    fun usBox(): Flowable<DBSubjectResult>

    /**
     * 新片榜
     */
    @GET("v2/movie/new_movies")
    fun newMovies(): Flowable<DBSubjectResult>

    /**
     * 影片详情
     */
    @GET("v2/movie/subject/{subjectId}")
    fun getSubjectDetail(@Path("subjectId") id: String): Flowable<Subject>


    /**
     * 电影剧照
     */
    @GET("v2/movie/subject/{subjectId}/photos")
    fun getSubjectPhotos(@Path("subjectId") id: String): Flowable<DBPhotosResult>

    /**
     * 演员信息
     */
    @GET("v2/movie/celebrity/{celebrityId}")
    fun getCelebrity(@Path("celebrityId") id: String): Flowable<Celebrity>

    /**
     * 获取演员照片
     */
    @GET("v2/movie/celebrity/{celebrityId}/photos")
    fun getCelebrityPhotos(@Path("celebrityId") id: String): Flowable<DBCelebrityPhotos>

    /**
     * 搜索影片
     */
    @GET("v2/movie/search")
    fun search(@Query("q") content: String,
               @Query("start") start: Int,
               @Query("count") count: Int): Flowable<DBSubjectResult>

}