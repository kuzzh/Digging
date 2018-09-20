package com.movies.douqi.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.movies.douqi.R
import com.movies.douqi.base.BaseActivity
import com.movies.douqi.extensions.inTransaction
import com.movies.douqi.ui.dytt.DyttFragment
import kotlinx.android.synthetic.main.activity_movie_detail.*

/**
 * @author donnieSky
 * @created_at 2018/9/3.
 * @description
 * @version
 */
class MovieDetailActivity : BaseActivity() {

    private val title: String by lazy {
        intent.getStringExtra(ARGS_MOVIE_DETAIL_TITLE)
    }

    companion object {
        private const val ARGS_MOVIE_DETAIL_TITLE = "ARGS_MOVIE_DETAIL_TITLE"
        fun startIntent(context: Context, title: String): Intent {
            return Intent(context, MovieDetailActivity::class.java).apply {
                putExtra(ARGS_MOVIE_DETAIL_TITLE, title)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbar)
        setTitle(title)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setNavigationOnClickListener { onBackPressed() }
        if (savedInstanceState == null) {
            supportFragmentManager.inTransaction {
                add(R.id.detail_container, DyttFragment.newInstance(title))
            }
        }
    }

}