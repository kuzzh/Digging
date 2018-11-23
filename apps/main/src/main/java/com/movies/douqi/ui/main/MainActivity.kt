package com.movies.douqi.ui.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import com.movies.douqi.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: MainViewModel

    private lateinit var currentFragment: Fragment

    lateinit var searchView: SearchView

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
                    title = getString(R.string.title_home)
                }
                R.id.navigation_dashboard -> {
                    title = getString(R.string.title_dashboard)
                }
                R.id.navigation_notifications -> {

                }
            }
            drawer.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

        /*model = ViewModelProviders.of(this, factory)
                .get(MainViewModel::class.java)*/

        if (savedInstanceState == null) {

        } else {
            currentFragment = supportFragmentManager.findFragmentById(R.id.container)
                    ?: throw IllegalStateException("Activity reCreated, but no fragment found!")
        }
    }

    private fun <F> replaceFragment(fragment: F) where F : Fragment {
        /*supportFragmentManager.inTransaction {
            currentFragment = fragment
            replace(R.id.container, fragment)
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val item = menu.findItem(R.id.action_search)
        searchView = MenuItemCompat.getActionView(item) as SearchView
        searchView.setIconifiedByDefault(true)
        searchView.queryHint = "搜索电影/电视剧"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    // startActivity(MovieDetailActivity.startIntent(this@MainActivity, query))
                }
                searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
        if (menu != null) {
            if (menu.javaClass.simpleName.equals("MenuBuilder", true)) {
                try {
                    val method = menu.javaClass.getDeclaredMethod("setOptionalIconsVisible", Boolean::class.java)
                    method.isAccessible = true
                    method.invoke(menu, true)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        return super.onMenuOpened(featureId, menu)
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
