package com.movies.douqi

import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
abstract class BaseActivity : DaggerAppCompatActivity() {

    open fun handleIntent(intent: Intent) {}

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }
}