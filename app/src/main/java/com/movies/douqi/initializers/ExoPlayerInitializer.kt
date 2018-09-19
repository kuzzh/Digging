package com.movies.douqi.initializers

import android.app.Application
import com.shuyu.gsyvideoplayer.cache.CacheFactory
import com.shuyu.gsyvideoplayer.player.PlayerFactory
import tv.danmaku.ijk.media.exo2.Exo2PlayerManager
import tv.danmaku.ijk.media.exo2.ExoPlayerCacheManager
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/19.
 * @description
 * @version
 */
class ExoPlayerInitializer @Inject constructor() : Initializer {
    override fun init(application: Application) {
        PlayerFactory.setPlayManager(Exo2PlayerManager())
        CacheFactory.setCacheManager(ExoPlayerCacheManager())
    }
}