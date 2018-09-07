package com.movies.data.resultentities

import androidx.room.Embedded
import androidx.room.Relation
import com.movies.data.entities.Film
import com.movies.data.entities.InTheaterFilmEntry
import java.util.*

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
class InTheaterEntryWithFilm : EntryWithFilm<InTheaterFilmEntry> {
    @Embedded
    override var entry: InTheaterFilmEntry? = null

    @Relation(parentColumn = "film_id", entityColumn = "id")
    override var relations: List<Film> = emptyList()

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is InTheaterEntryWithFilm -> entry == other.entry && relations == other.relations
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(entry, relations)
}