package com.movies.data.resultentities

import androidx.room.Embedded
import androidx.room.Relation
import com.movies.data.entities.Film
import com.movies.data.entities.InTheaterEntry
import java.util.*

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
class InTheaterEntryWithFilm : EntryWithShow<InTheaterEntry> {
    @Embedded
    override var entry: InTheaterEntry? = null

    @Relation(parentColumn = "entry_id",
            entityColumn = "id")
    override var relations: List<Film> = emptyList()

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is InTheaterEntryWithFilm -> entry == other.entry && relations == other.relations
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(entry, relations)
}