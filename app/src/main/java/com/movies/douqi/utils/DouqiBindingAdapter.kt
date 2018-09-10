package com.movies.douqi.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.doOnLayout
import androidx.databinding.BindingAdapter

/**
 * @author donnieSky
 * @created_at 2018/8/31.
 * @description
 * @version
 */

@BindingAdapter("url")
fun ImageView.loadFilm(url: String?) {
    GlideApp.with(this).clear(this)
    if (url != null) {
        this.doOnLayout {
            GlideApp.with(this)
                    .saturateOnLoad()
                    .load(url)
                    .centerCrop()
                    .into(this)
        }
    }
}

@BindingAdapter("visibleIfNotNull")
fun View.visibleIfNotNull(target: Any?) {
    this.visibility = if (target == null) View.GONE else View.VISIBLE
}