package com.movies.data.utils

import com.movies.data.daos.EntityDao
import com.movies.data.entities.IEntity
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
class EntityInserter @Inject constructor(
        private val runner: DatabaseTransactionRunner
) {

    fun <E : IEntity> insertOrUpdate(dao: EntityDao<E>, entities: List<E>) = runner {
        entities.forEach {
            insertOrUpdate(dao, it)
        }
    }

    fun <E : IEntity> insertOrUpdate(dao: EntityDao<E>, entity: E): Long = when {
        entity.id == 0L -> dao.insert(entity)
        else -> {
            dao.update(entity)
            entity.id
        }
    }

}