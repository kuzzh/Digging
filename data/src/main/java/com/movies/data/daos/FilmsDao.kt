package com.movies.data.daos


import androidx.room.Dao
import androidx.room.Query
import com.movies.data.entities.Film

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Dao
abstract class FilmsDao : EntityDao<Film> {

    @Query("SELECT * FROM films WHERE id = :id")
    abstract fun filmWithId(id: Long): Film?

}