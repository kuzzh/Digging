package com.movies.data.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.movies.data.entities.MovieEntity

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
interface EntityDao<in E : MovieEntity> {

    @Insert
    fun insert(entity: E): Long

    @Insert
    fun insertAll(vararg entity: E)

    @Insert
    fun insertAll(entities: List<E>)

    @Update
    fun update(entity: E)

    @Delete
    fun delete(entity: E): Int

}