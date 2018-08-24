package com.movies.dytt.services

import com.movies.dytt.entities.CategoryList
import com.movies.dytt.entities.Movie
import com.movies.dytt.entities.MovieList
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
interface DYTTApi {

    @GET("adminapi/api/movieCategory.json")
    fun getMovieCategories(): Flowable<CategoryList>

    @GET("adminapi/api/movieList.json")
    fun getMovieList(@Query("categoryId") categoryId: Int,
                     @Query("page") page: Int): Flowable<MovieList<Movie>>

    @GET("adminapi/api/movieDetail.json")
    fun getMovieDetail(@Query("categoryId") categoryId: Int,
                       @Query("movieDetailId") movieId: Long): Flowable<Movie>

    @GET("adminapi/api/movieList.json")
    fun searchMovie(@Query("categoryId") categoryId: Int? = 0,
                    @Query("page") page: Int,
                    @Query("searchContent") search: String): Flowable<MovieList<Movie>>

}