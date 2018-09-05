package com.movies.data

import java.util.concurrent.Callable

/**
 * @author donnieSky
 * @created_at 2018/9/5.
 * @description
 * @version
 */
class RoomTransactionRunner(private val db: DouqiDatabase) : DatabaseTransactionRunner {
    override operator fun <T> invoke(run: () -> T): T = db.runInTransaction(Callable<T> { run() })
}