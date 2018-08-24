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
@Entity(tableName = "seeds",
        indices = [Index(value = ["seed_id"], unique = true)])
data class Seed(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        override val movieId: Long? = null,
        @ColumnInfo(name = "seed_id")
        val id: Long,
        @ColumnInfo(name = "seed_category_id")
        val categoryId: Int? = null,
        @ColumnInfo(name = "seed_name")
        val name: String? = null,
        @ColumnInfo(name = "seed_publish_time")
        val publishTime: String? = null,
        @ColumnInfo(name = "seed_image")
        val homePicUrl: String? = null,
        @ColumnInfo(name = "seed_content")
        val content: String? = null,
        @ColumnInfo(name = "seed_intro_pics")
        val pics: String? = null,
        @ColumnInfo(name = "seed_download_url")
        val downloadUrl: String? = null
) : MovieEntity {
    companion object {
        val EMPTY = Seed(id = 0)
    }
}