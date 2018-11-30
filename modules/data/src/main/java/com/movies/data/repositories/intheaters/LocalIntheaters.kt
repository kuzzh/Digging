package com.movies.data.repositories.intheaters

import com.movies.data.daos.VideoDao
import com.movies.data.entities.Video
import com.movies.data.utils.DatabaseTransactionRunner
import com.movies.data.utils.EntityInserter
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
class LocalIntheaters @Inject constructor(
        private val runner: DatabaseTransactionRunner,
        private val inserter: EntityInserter,
        private val dao: VideoDao
) {

    fun save(entity: Video) = inserter.insertOrUpdate(dao, entity)

    fun save(entities: List<Video>) = inserter.insertOrUpdate(dao, entities)

    fun getIntheaters(count: Int, offset: Int): Flowable<List<Video>> {
        return dao.entire(count, offset)
    }

    fun deleteAll() = dao.deleteAll()

    fun getPageSize(): Int? = dao.getEntityCount()

}