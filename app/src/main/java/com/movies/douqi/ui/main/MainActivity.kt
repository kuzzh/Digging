package com.movies.douqi.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.movies.douqi.R
import com.movies.douqi.base.BaseActivity
import com.movies.douqi.extensions.inTransaction
import com.movies.douqi.ui.douban.DoubanFragment
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity() {

    private lateinit var model: MainViewModel

    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        model = ViewModelProviders.of(this, factory)
                .get(MainViewModel::class.java)

        if (savedInstanceState == null) {
            replaceFragment(DoubanFragment())
        } else {
            currentFragment = supportFragmentManager.findFragmentById(R.id.container)
                    ?: throw IllegalStateException("Activity reCreated, but no fragment found!")
        }
    }

    private fun <F> replaceFragment(fragment: F) where F : Fragment {
        supportFragmentManager.inTransaction {
            currentFragment = fragment
            replace(R.id.container, fragment)
        }
    }
}
