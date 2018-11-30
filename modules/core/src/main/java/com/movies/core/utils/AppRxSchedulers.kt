package com.movies.core.utils

import io.reactivex.Scheduler

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
data class AppRxSchedulers(
        val io: Scheduler,
        val computation: Scheduler,
        val main: Scheduler
)