package com.movies.douqi.utils

import android.graphics.drawable.Drawable
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.request.transition.NoTransition
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.request.transition.TransitionFactory
import com.movies.douqi.animations.saturateDrawableAnimator

/**
 * @author donnieSky
 * @created_at 2018/8/31.
 * @description
 * @version
 */
class SaturationTransitionFactory : TransitionFactory<Drawable> {
    override fun build(dataSource: DataSource?, isFirstResource: Boolean): Transition<Drawable> {
        return if (isFirstResource && dataSource != DataSource.MEMORY_CACHE) {
            SaturationTransition()
        } else {
            NoTransition<Drawable>()
        }
    }
}


internal class SaturationTransition : Transition<Drawable> {
    override fun transition(current: Drawable, adapter: Transition.ViewAdapter): Boolean {
        saturateDrawableAnimator(current, adapter.view).also {
            it.start()
        }
        // We want Glide to still set the drawable
        return false
    }
}