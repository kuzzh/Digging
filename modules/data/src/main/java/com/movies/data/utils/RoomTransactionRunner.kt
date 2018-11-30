package com.movies.data.utils

import com.movies.data.DB
import java.util.concurrent.Callable

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
class RoomTransactionRunner(private val db: DB) : DatabaseTransactionRunner {
    override fun <T> invoke(run: () -> T): T = db.runInTransaction(Callable<T> { run() })
}