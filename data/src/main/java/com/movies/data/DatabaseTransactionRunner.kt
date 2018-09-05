package com.movies.data

/**
 * @author donnieSky
 * @created_at 2018/8/23.
 * @description
 * @version
 */
interface DatabaseTransactionRunner {
    operator fun <T> invoke(run: () -> T): T
}