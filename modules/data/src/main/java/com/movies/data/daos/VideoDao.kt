package com.movies.data.daos

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.movies.data.entities.Video
import io.reactivex.Flowable

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
@Dao
abstract class VideoDao : EntityDao<Video> {

    @Transaction
    @Query("SELECT * FROM videos ORDER BY rating DESC LIMIT :count OFFSET :offset")
    abstract override fun entire(count: Int, offset: Int): Flowable<List<Video>>

    @Query("SELECT * FROM videos ORDER BY id DESC")
    abstract fun entirePaging(): DataSource.Factory<Int, Video>

    @Query("SELECT COUNT(id) FROM videos")
    abstract fun getEntityCount(): Int?

    @Query("DELETE FROM videos")
    abstract override fun deleteAll()
}