package com.movies.douqi.utils

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.annotation.GlideType
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

/**
 * @author donnieSky
 * @created_at 2018/8/31.
 * @description
 * @version
 */
@SuppressLint("CheckResult")
@GlideExtension
object GlideExtensions {

    @GlideOption
    @JvmStatic
    fun round(options: RequestOptions, size: Int): RequestOptions {
        return options.circleCrop().override(size)
    }

    @GlideType(Drawable::class)
    @JvmStatic
    fun saturateOnLoad(requestBuilder: RequestBuilder<Drawable>) {
        requestBuilder.transition(DrawableTransitionOptions.with(SaturationTransitionFactory()))
    }
}