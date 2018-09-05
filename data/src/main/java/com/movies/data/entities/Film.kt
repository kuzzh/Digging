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
            Index(value = ["douban_id"], unique = true),
            Index(value = ["dytt_id"], unique = true)
        ])
data class Film(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        override val id: Long = 0,
        @ColumnInfo(name = "douban_id")
        override val doubanId: String? = null,
        @ColumnInfo(name = "dytt_id")
        override val dyttId: Long? = null,
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
        val images: String? = null,
        @ColumnInfo(name = "download_url")
        val downloadUrl: String? = null
) : MovieEntity, DoubanIdEntity, DyttIdEntity {

    @Ignore
    constructor() : this(0)

    companion object {
        val EMPTY_FILM = Film()
    }
}