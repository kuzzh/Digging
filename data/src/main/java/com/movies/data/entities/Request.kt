package com.movies.data.entities

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
enum class Request(val tag: String) {
    IN_THEATERS("in_theaters"),
    COMING_SOON("coming_soon"),
    TOP_FILMS("top_films"),
    WEEKLY_FILMS("weekly_films"),
    US_BOX("us_box"),
    NEW_MOVIES("new_movies"),
    FILM_DETAIL("film_details")
}