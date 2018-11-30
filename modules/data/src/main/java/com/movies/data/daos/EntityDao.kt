package com.movies.data.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.movies.data.entities.IEntity
import io.reactivex.Flowable

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
interface EntityDao<E : IEntity> {

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

    fun entire(count: Int, offset: Int): Flowable<List<E>>

    fun deleteAll()

}