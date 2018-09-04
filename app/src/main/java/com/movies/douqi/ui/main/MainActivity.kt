package com.movies.douqi.ui.main

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.movies.douqi.R
import com.movies.douqi.base.BaseActivity
import com.movies.douqi.extensions.inTransaction
import com.movies.douqi.ui.douban.DoubanFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity() {

    private lateinit var model: MainViewModel

    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(DoubanFragment())
                }
                R.id.navigation_dashboard -> {

                }
                R.id.navigation_notifications -> {

                }
            }
            drawer.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

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

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
