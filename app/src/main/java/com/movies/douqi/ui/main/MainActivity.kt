package com.movies.douqi.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.movies.douqi.R
import com.movies.douqi.base.BaseActivity
import com.movies.douqi.extensions.observeByNull
import com.movies.douqi.ui.douban.DoubanFragment
import com.movies.douqi.ui.dytt.DyttFragment
import com.movies.douqi.ui.other.TestFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    companion object {
        const val ROOT_FRAGMENT = "root"
    }

    lateinit var model: MainViewModel

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                model.onNavigationItemClicked(MainViewModel.NavigationItem.DOUBAN)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                model.onNavigationItemClicked(MainViewModel.NavigationItem.DYTT)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                model.onNavigationItemClicked(MainViewModel.NavigationItem.OTHER)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(
                mOnNavigationItemSelectedListener
        )
        model = ViewModelProviders.of(this, factory)
                .get(MainViewModel::class.java)

        model.navigationLiveData.observeByNull(this, this::showNavigationItem)
    }

    private fun showNavigationItem(item: MainViewModel.NavigationItem?) {
        if (item == null) {
            return
        }
        val newFragment: Fragment
        val newItemId: Int

        when (item) {
            MainViewModel.NavigationItem.DOUBAN -> {
                newFragment = DoubanFragment()
                newItemId = R.id.navigation_home
            }
            MainViewModel.NavigationItem.DYTT -> {
                newFragment = DyttFragment()
                newItemId = R.id.navigation_dashboard
            }
            MainViewModel.NavigationItem.OTHER -> {
                newFragment = TestFragment()
                newItemId = R.id.navigation_notifications
            }
        }

        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
        }
        supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.container, newFragment, ROOT_FRAGMENT)
                .commit()

        if (navigation.selectedItemId != newItemId) {
            navigation.menu.findItem(newItemId)?.isChecked = true
        }
    }
}
