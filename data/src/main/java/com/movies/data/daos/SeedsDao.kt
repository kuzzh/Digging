package com.movies.data.daos

import androidx.room.Dao
import androidx.room.Query
import com.movies.data.entities.Seed

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Dao
abstract class SeedsDao : EntityDao<Seed> {

    @Query("SELECT * FROM seeds WHERE id = :id")
    abstract fun seedsWithId(id: Long): Seed?

}