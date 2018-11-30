package com.movies.core.initializers

import android.app.Application

/**
 * @author donnieSky
 * @created_at 2018/11/28.
 * @description
 * @version
 */
interface Initializer {
    fun init(application: Application)
}