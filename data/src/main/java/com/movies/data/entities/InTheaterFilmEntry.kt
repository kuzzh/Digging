package com.movies.data.entities

import androidx.room.*
import com.movies.data.PaginatedEntry

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
@Entity(tableName = "in_theaters",
        indices = [Index(value = ["film_id"], unique = true)],
        foreignKeys = [
            ForeignKey(entity = Film::class,
                    parentColumns = arrayOf("id"),
                    childColumns = arrayOf("film_id"),
                    onUpdate = ForeignKey.CASCADE,
                    onDelete = ForeignKey.CASCADE)
        ])
data class InTheaterFilmEntry(
        @PrimaryKey(autoGenerate = true)
        override val id: Long = 0,
        @ColumnInfo(name = "film_id")
        override val filmId: Long,
        @ColumnInfo(name = "page")
        override val page: Int,
        @ColumnInfo(name = "page_order")
        val pageOrder: Int
) : PaginatedEntry