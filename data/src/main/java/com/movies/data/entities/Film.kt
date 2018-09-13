package com.movies.data.entities

import androidx.room.*


/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Entity(tableName = "films",
        indices = [
            Index(value = ["douban_id"], unique = true)
        ])
data class Film(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        override val id: Long = 0,
        @ColumnInfo(name = "douban_id")
        override val doubanId: String? = null,
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
        val ratingsCount: Double? = null,
        @ColumnInfo(name = "film_image")
        val images: String? = null
) : MovieEntity, DoubanIdEntity {

    @Ignore
    constructor() : this(0)

    companion object {
        val EMPTY_FILM = Film()
    }
}