package com.movies.douqi.initializers

import android.app.Application

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
interface Initializer {
    fun init(application: Application)
}