package com.movies.utils

import io.reactivex.Scheduler

/**
 * @author donnieSky
 * @created_at 2018/8/21.
 * @description
 * @version
 */
data class AppRxSchedulers(
        val io: Scheduler,
        val computation: Scheduler,
        val main: Scheduler
)