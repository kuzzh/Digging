package com.movies.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.movies.data.daos.VideoDao
import com.movies.data.entities.Video

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
@Database(
        entities = [Video::class],
        version = 1
)
abstract class DB : RoomDatabase() {
    abstract fun videoDao(): VideoDao
}