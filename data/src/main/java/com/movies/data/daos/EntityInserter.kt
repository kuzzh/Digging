package com.movies.data.daos

import com.movies.data.DBTransactionRunner
import com.movies.data.entities.MovieEntity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
@Singleton
class EntityInserter @Inject constructor(
        private val transaction: DBTransactionRunner
) {

    fun <E : MovieEntity> insertOrUpdate(dao: EntityDao<E>, entities: List<E>) = transaction {
        entities.forEach {
            insertOrUpdate(dao, it)
        }
    }

    fun <E : MovieEntity> insertOrUpdate(dao: EntityDao<E>, entity: E): Long = when {
        entity.movieId == null -> dao.insert(entity)
        else -> {
            dao.update(entity)
            entity.movieId!!
        }
    }

}