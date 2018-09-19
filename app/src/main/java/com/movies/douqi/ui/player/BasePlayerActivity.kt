package com.movies.douqi.ui.player

import android.content.res.Configuration
import com.movies.douqi.base.BaseActivity
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder
import com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer

/**
 * @author donnieSky
 * @created_at 2018/9/19.
 * @description
 * @version
 */
abstract class BasePlayerActivity<T : GSYBaseVideoPlayer> : BaseActivity(), VideoAllCallBack {

    protected var isPlay: Boolean = false

    protected var isPause: Boolean = false

    protected var orientationUtils: OrientationUtils? = null

    fun initVideo() {
        orientationUtils = OrientationUtils(this, getVideoPlayer())
        orientationUtils!!.isEnable = false
        if (getVideoPlayer().fullscreenButton != null) {
            getVideoPlayer().fullscreenButton.setOnClickListener {
                fullScreen()
                clickForFullScreen()
            }
        }
    }

    fun initVideoBuilderMode() {
        initVideo()
        getVideoOptionBuilder()
                .setVideoAllCallBack(this)
                .build(getVideoPlayer())
    }

    fun fullScreen() {
        if (orientationUtils!!.isLand != 1) {
            orientationUtils!!.resolveByClick()
        }
        getVideoPlayer().startWindowFullscreen(this,
                hideActionBarWhenFullScreen(), hideStatusBarWhenFullScreen())
    }

    fun hideActionBarWhenFullScreen(): Boolean {
        return true
    }

    fun hideStatusBarWhenFullScreen(): Boolean {
        return true
    }

    override fun onResume() {
        super.onResume()
        getVideoPlayer().currentPlayer.onVideoResume()
        isPause = false
    }

    override fun onPause() {
        super.onPause()
        getVideoPlayer().currentPlayer.onVideoPause()
        isPause = true
    }

    override fun onBackPressed() {
        if (orientationUtils != null) {
            orientationUtils!!.backToProtVideo()
        }
        if (GSYVideoManager.backFromWindowFull(this)) {
            return
        }
        super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isPlay) {
            getVideoPlayer().currentPlayer.release()
        }
        if (orientationUtils != null) {
            orientationUtils!!.releaseListener()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        if (isPlay && !isPause) {
            getVideoPlayer().onConfigurationChanged(
                    this,
                    newConfig,
                    orientationUtils,
                    hideActionBarWhenFullScreen(),
                    hideStatusBarWhenFullScreen())
        }
    }

    override fun onStartPrepared(url: String?, vararg objects: Any?) {

    }

    override fun onPrepared(url: String?, vararg objects: Any?) {
        if (orientationUtils == null) {
            throw NullPointerException("initVideo or initVideoBuilderMode first !")
        }
        orientationUtils?.isEnable = getPlayerOrientationRotateAuto() && !isAutoFullScreenWithSize()
        isPlay = true
    }

    override fun onClickStartIcon(url: String?, vararg objects: Any?) {

    }

    override fun onClickStartError(url: String?, vararg objects: Any?) {

    }

    override fun onClickStop(url: String?, vararg objects: Any?) {

    }

    override fun onClickResumeFullscreen(url: String?, vararg objects: Any?) {

    }

    override fun onEnterFullscreen(url: String?, vararg objects: Any?) {
    }

    override fun onClickResume(url: String?, vararg objects: Any?) {
    }

    override fun onClickSeekbarFullscreen(url: String?, vararg objects: Any?) {
    }

    override fun onTouchScreenSeekLight(url: String?, vararg objects: Any?) {
    }

    override fun onQuitFullscreen(url: String?, vararg objects: Any?) {
        if (orientationUtils != null) {
            orientationUtils!!.backToProtVideo()
        }
    }

    override fun onClickStartThumb(url: String?, vararg objects: Any?) {
    }

    override fun onEnterSmallWidget(url: String?, vararg objects: Any?) {
    }

    override fun onClickBlankFullscreen(url: String?, vararg objects: Any?) {
    }

    override fun onAutoComplete(url: String?, vararg objects: Any?) {
    }

    override fun onQuitSmallWidget(url: String?, vararg objects: Any?) {
    }

    override fun onTouchScreenSeekVolume(url: String?, vararg objects: Any?) {
    }

    override fun onClickBlank(url: String?, vararg objects: Any?) {
    }

    override fun onClickSeekbar(url: String?, vararg objects: Any?) {
    }

    override fun onPlayError(url: String?, vararg objects: Any?) {
    }

    override fun onClickStopFullscreen(url: String?, vararg objects: Any?) {
    }

    override fun onTouchScreenSeekPosition(url: String?, vararg objects: Any?) {
    }

    fun isAutoFullScreenWithSize() = false

    abstract fun getVideoPlayer(): T

    abstract fun getVideoOptionBuilder(): GSYVideoOptionBuilder

    abstract fun clickForFullScreen()

    abstract fun getPlayerOrientationRotateAuto(): Boolean
}