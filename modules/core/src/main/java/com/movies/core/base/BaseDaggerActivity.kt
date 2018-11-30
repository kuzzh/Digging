package com.movies.core.base

import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.movies.core.extensions.inTransaction
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/28.
 * @description
 * @version
 */
abstract class BaseDaggerActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var currentFragment: Fragment

    open fun handleIntent(intent: Intent?) {}

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    fun <F> replaceFragment(@IdRes id: Int, fragment: F) where F : Fragment {
        supportFragmentManager.inTransaction {
            currentFragment = fragment
            replace(id, fragment)
        }
    }
}