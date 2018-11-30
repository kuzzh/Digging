package com.movies.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
@Entity(tableName = "videos")
data class Video(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        override val id: Long = 0,
        @ColumnInfo(name = "from")
        val from: String? = null,
        @ColumnInfo(name = "from_id")
        val fromId: String? = null,
        @ColumnInfo(name = "title")
        val title: String? = null,
        @ColumnInfo(name = "summary")
        val summary: String? = null,
        @ColumnInfo(name = "picture_url")
        val picture: String? = null,
        @ColumnInfo(name = "rating")
        val rating: Double? = null
) : IEntity {

    companion object {
        val EMPTY = Video()
    }

}