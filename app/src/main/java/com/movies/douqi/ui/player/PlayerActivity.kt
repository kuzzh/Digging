package com.movies.douqi.ui.player

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.movies.douqi.R
import com.movies.douqi.base.BaseActivity
import com.movies.douqi.extensions.observeNotNull
import com.movies.mahua.entities.Episode
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import kotlinx.android.synthetic.main.activity_player.*

/**
 * @author donnieSky
 * @created_at 2018/9/19.
 * @description
 * @version
 */
class PlayerActivity : BaseActivity() {

    lateinit var model: PlayerViewModel

    private val controller = EpisodeController()

    private var isFilm: Boolean = false

    private val videoId: Long by lazy {
        intent.getLongExtra(ARGS_MOVIE_PLAYER_ID, 0)
    }

    private lateinit var orientationUtils: OrientationUtils

    companion object {
        private const val ARGS_MOVIE_PLAYER_ID = "ARGS_MOVIE_PLAYER_ID"
        fun startIntent(context: Context, videoId: Long): Intent {
            return Intent(context, PlayerActivity::class.java).apply {
                putExtra(ARGS_MOVIE_PLAYER_ID, videoId)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setNavigationOnClickListener { onBackPressed() }
        controller.callbacks = object : EpisodeController.Callbacks {
            override fun onItemClicked(item: Episode) {
                val title = if (!isFilm) {
                    "${item.title} 第${item.sortNum}集"
                } else {
                    item.title
                }
                val url = "${item.m3u8PlayUrl}${when {
                    item.m3u8Format!!.`1080P` != null -> item.m3u8Format!!.`1080P`
                    item.m3u8Format!!.`720P` != null -> item.m3u8Format!!.`720P`
                    item.m3u8Format!!.`480P` != null -> item.m3u8Format!!.`480P`
                    else -> item.m3u8Format!!.free
                }}"
                player.setUp(url, true, title)
                player.startPlayLogic()
                orientationUtils.isEnable = true
            }
        }
        recycler.apply {
            itemAnimator = null
            setController(controller)
            addItemDecoration(DividerItemDecoration(this@PlayerActivity, DividerItemDecoration.VERTICAL))
        }
        model = ViewModelProviders.of(this, factory).get(PlayerViewModel::class.java)
        initPlayer()
        model.data.observeNotNull(this) {
            if (it.videoList != null && it.videoList!!.isNotEmpty()) {
                if (it.type == 1) {
                    isFilm = true
                    title = it.title
                }
                title = it.title
                controller.setData(it.videoList)
            }
        }

        model.getVideoInfo(videoId)
    }

    private fun initPlayer() {
        orientationUtils = OrientationUtils(this, player)
        orientationUtils.isEnable = false
        player.backButton.visibility = View.VISIBLE
        player.fullscreenButton.setOnClickListener {
            if (orientationUtils.isLand != 1) {
                orientationUtils.resolveByClick()
            }
            player.startWindowFullscreen(this, true, true)
        }
        player.setIsTouchWiget(true)
        player.isRotateViewAuto = false
        player.isLockLand = false
        player.isShowFullAnimation = false
        player.isNeedLockFull = true
        player.seekRatio = 1.toFloat()
        player.isRotateViewAuto = true
        player.setVideoAllCallBack(object : VideoPlayCallback() {
            override fun onQuitFullscreen(url: String?, vararg objects: Any?) {
                orientationUtils.backToProtVideo()
            }
        })
        player.backButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onPause() {
        super.onPause()
        player.onVideoPause()
    }

    override fun onResume() {
        super.onResume()
        player.onVideoResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.currentPlayer.release()
        GSYVideoManager.releaseAllVideos()
        orientationUtils.releaseListener()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        player.onConfigurationChanged(this, newConfig, orientationUtils, true, true)
    }

    override fun onBackPressed() {
        orientationUtils.backToProtVideo()
        if (GSYVideoManager.backFromWindowFull(this)) {
            return
        }
        super.onBackPressed()
    }
}