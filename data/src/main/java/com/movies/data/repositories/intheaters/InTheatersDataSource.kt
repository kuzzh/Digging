package com.movies.data.repositories.intheaters

import com.movies.data.entities.Film
import com.movies.data.entities.InTheaterEntry
import com.movies.data.entities.Result

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
interface InTheatersDataSource {

    suspend fun getInTheaters(page: Int, pageSize: Int): Result<List<Pair<Film, InTheaterEntry>>>

}