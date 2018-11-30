package com.movies.data.utils

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
interface DatabaseTransactionRunner {

    operator fun <T> invoke(run: () -> T): T

}