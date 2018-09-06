package com.movies.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.movies.data.entities.LastRequest
import com.movies.data.entities.Request
import org.threeten.bp.Instant
import org.threeten.bp.temporal.TemporalAmount

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
@Dao
abstract class LastRequestDao : EntityDao<LastRequest> {

    @Query("SELECT * FROM last_requests WHERE request = :request AND entity_id = :entityId")
    protected abstract fun lastRequest(request: Request, entityId: Long): LastRequest?

    @Query("SELECT COUNT(*) FROM last_requests WHERE request = :request AND entity_id = :entityId")
    protected abstract fun requestCount(request: Request, entityId: Long): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override fun insert(entity: LastRequest): Long

    fun hasBeenRequested(request: Request, entityId: Long) = requestCount(request, entityId) > 0

    fun hasNotBeenRequested(request: Request, entityId: Long) = requestCount(request, entityId) <= 0

    fun isRequestBefore(request: Request, entityId: Long, threshold: TemporalAmount): Boolean {
        val lastRequest = lastRequest(request, entityId)
        return lastRequest?.timestamp?.isBefore(Instant.now().minus(threshold)) ?: true
    }

    fun updateLastRequest(request: Request, entityId: Long, timestamp: Instant = Instant.now()) {
        val lastRequest = LastRequest(request = request, entityId = entityId, timestamp = timestamp)
        insert(lastRequest)
    }

}