package com.movies.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.movies.data.daos.FilmsDao
import com.movies.data.daos.InTheaterDao
import com.movies.data.daos.LastRequestDao
import com.movies.data.entities.Film
import com.movies.data.entities.InTheaterEntry
import com.movies.data.entities.LastRequest

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
@Database(
        entities = [
            Film::class,
            InTheaterEntry::class,
            LastRequest::class
        ],
        version = 1
)
@TypeConverters(DouqiTypeConverters::class)
abstract class DouqiDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmsDao
    abstract fun inTheaterDao(): InTheaterDao
    abstract fun lastRequestDao(): LastRequestDao
}