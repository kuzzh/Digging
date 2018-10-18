package com.movies.douqi.ui.tivi

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import com.movies.douqi.R
import com.movies.douqi.base.BaseActivity
import com.movies.douqi.ui.player.VideoPlayCallback
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import kotlinx.android.synthetic.main.activity_tivi_player.*

/**
 * @author donnieSky
 * @created_at 2018/10/18.
 * @description
 * @version
 */
class TiviPlayerActivity : BaseActivity() {

    private val videoUrl: String? by lazy {
        intent.getStringExtra(ARGS_TIVI_PLAYER_URL)
    }

    private val videoName: String by lazy {
        intent.getStringExtra(ARGS_TIVI_PLAYER_NAME)
    }

    private lateinit var orientationUtils: OrientationUtils

    companion object {
        private const val ARGS_TIVI_PLAYER_URL = "ARGS_TIVI_PLAYER_URL"
        private const val ARGS_TIVI_PLAYER_NAME = "ARGS_TIVI_PLAYER_NAME"
        fun startIntent(context: Context,
                        videoName: String,
                        videoUrl: String): Intent {
            return Intent(context, TiviPlayerActivity::class.java).apply {
                putExtra(ARGS_TIVI_PLAYER_NAME, videoName)
                putExtra(ARGS_TIVI_PLAYER_URL, videoUrl)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tivi_player)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setNavigationOnClickListener { onBackPressed() }
        initPlayer()

        if (videoUrl != null && videoUrl!!.isNotEmpty()) {
            player.setUp(videoUrl, true, videoName)
            player.startPlayLogic()
            orientationUtils.isEnable = true
        }
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