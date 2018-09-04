package com.movies.dytt.services

import com.movies.dytt.entities.CategoryList
import com.movies.dytt.entities.Movie
import com.movies.dytt.entities.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
interface DYTTService {

    @GET("adminapi/api/movieCategory.json")
    fun getMovieCategories(): Call<CategoryList>

    @GET("adminapi/api/movieList.json")
    fun getMovieList(@Query("categoryId") categoryId: Int,
                     @Query("page") page: Int): Call<MovieList<Movie>>

    @GET("adminapi/api/movieDetail.json")
    fun getMovieDetail(@Query("categoryId") categoryId: Int,
                       @Query("movieDetailId") movieId: Long): Call<Movie>

    @GET("adminapi/api/movieList.json")
    fun searchMovie(@Query("categoryId") categoryId: Int? = 0,
                    @Query("page") page: Int,
                    @Query("searchContent") search: String): Call<MovieList<Movie>>

}