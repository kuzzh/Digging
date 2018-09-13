package com.movies.douban.services

import com.movies.douban.entities.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
interface DoubanService {

    /**
     * 正在上映的电影
     */
    @GET("v2/movie/in_theaters")
    fun inTheaters(@Query("start") start: Int,
                   @Query("count") count: Int): Call<DBSubjectResult>

    /**
     * 即将上映的电影
     */
    @GET("v2/movie/coming_soon")
    fun comingSoon(): Call<DBSubjectResult>

    /**
     * top250的电影
     */
    @GET("v2/movie/top250")
    fun top250(): Call<DBSubjectResult>

    /**
     * 口碑榜
     */
    @GET("v2/movie/weekly")
    fun weekly(): Call<DBSubjectResult>

    /**
     * 北美票房榜
     */
    @GET("v2/movie/us_box")
    fun usBox(): Call<DBSubjectResult>

    /**
     * 新片榜
     */
    @GET("v2/movie/new_movies")
    fun newMovies(): Call<DBSubjectResult>

    /**
     * 影片详情
     */
    @GET("v2/movie/subject/{subjectId}")
    fun getSubjectDetail(@Path("subjectId") id: String): Call<Subject>


    /**
     * 电影剧照
     */
    @GET("v2/movie/subject/{subjectId}/photos")
    fun getSubjectPhotos(@Path("subjectId") id: String): Call<DBPhotosResult>

    /**
     * 演员信息
     */
    @GET("v2/movie/celebrity/{celebrityId}")
    fun getCelebrity(@Path("celebrityId") id: String): Call<Celebrity>

    /**
     * 获取演员照片
     */
    @GET("v2/movie/celebrity/{celebrityId}/photos")
    fun getCelebrityPhotos(@Path("celebrityId") id: String): Call<DBCelebrityPhotos>

    /**
     * 搜索影片
     */
    @GET("v2/movie/search")
    fun search(@Query("q") content: String,
               @Query("start") start: Int,
               @Query("count") count: Int): Call<DBSubjectResult>

}