package com.movies.douqi.ui.player

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.movies.douqi.R
import com.movies.douqi.base.BaseActivity
import com.movies.douqi.extensions.observeNotNull
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
        model = ViewModelProviders.of(this, factory).get(PlayerViewModel::class.java)
        initPlayer()
        model.data.observeNotNull(this) {
            if (it.videoList != null && it.videoList!!.isNotEmpty()) {
                val episode = it.videoList!![0]
                val url = "${episode.m3u8PlayUrl}${if (episode.m3u8Format!!.`1080P` != null) episode.m3u8Format!!.`1080P`
                else episode.m3u8Format!!.`720P`}"
                player.setUp(url, true, episode.title)

                player.startPlayLogic()
            }
        }

        model.getVideoInfo(videoId)
    }

    private fun initPlayer() {
        orientationUtils = OrientationUtils(this, player)
        player.backButton.visibility = View.VISIBLE
        player.fullscreenButton.setOnClickListener {
            orientationUtils.resolveByClick()
            player.startWindowFullscreen(this, true, true)
        }
        player.setIsTouchWiget(true)
        player.isRotateViewAuto = false
        player.isLockLand = false
        player.isShowFullAnimation = true
        player.isNeedLockFull = true
        player.seekRatio = 1.toFloat()
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
        player.setVideoAllCallBack(null)
        super.onBackPressed()
    }
}