package com.movies.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Entity(tableName = "films",
        indices = [Index(value = ["film_id"], unique = true)])
data class Film(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        override val movieId: Long? = null,
        @ColumnInfo(name = "film_id")
        val id: String,
        @ColumnInfo(name = "film_name")
        val title: String? = null,
        @ColumnInfo(name = "film_original_name")
        val originalTitle: String? = null,
        val summary: String? = null,
        @ColumnInfo(name = "type")
        val subType: String? = null,
        val year: String? = null,
        val alt: String? = null,
        @ColumnInfo(name = "film_rating")
        val ratingsCount: Long? = null,
        @ColumnInfo(name = "film_image")
        val images: String? = null
) : MovieEntity {
    companion object {
        val EMPTY = Film(id = "0")
    }
}