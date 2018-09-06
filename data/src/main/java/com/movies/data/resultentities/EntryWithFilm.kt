package com.movies.data.resultentities

import com.movies.data.Entry
import com.movies.data.entities.Film
import java.util.*

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
interface EntryWithFilm<ET : Entry> {

    var entry: ET?
    var relations: List<Film>

    val film: Film
        get() {
            assert(relations.size == 1)
            return relations[0]
        }

    fun generateStableId(): Long {
        return Objects.hash(entry!!::class, film.id).toLong()
    }
}