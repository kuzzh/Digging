package com.movies.douqi.utils

import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888
import com.bumptech.glide.load.DecodeFormat.PREFER_RGB_565
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.movies.douqi.BuildConfig

/**
 * @author donnieSky
 * @created_at 2018/12/26.
 * @description
 * @version
 */
@GlideModule
class DouGlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val am = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager

        val options = RequestOptions()
                .format(if (am.isLowRamDevice) PREFER_RGB_565 else PREFER_ARGB_8888)

        builder.setDefaultRequestOptions(options)
        if (BuildConfig.DEBUG) {
            builder.setLogLevel(Log.VERBOSE)
        }
    }

    override fun isManifestParsingEnabled(): Boolean  = false
}