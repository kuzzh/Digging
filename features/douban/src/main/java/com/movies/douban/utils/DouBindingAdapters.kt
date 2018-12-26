package com.movies.douban.utils

import android.widget.ImageView
import androidx.core.view.doOnLayout
import androidx.databinding.BindingAdapter
import com.movies.douqi.utils.GlideApp

/**
 * @author donnieSky
 * @created_at 2018/12/26.
 * @description
 * @version
 */
@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    if (url != null) {
        this.doOnLayout {
            GlideApp.with(this)
                    .load(url)
                    .into(this)
        }
    } else {
        GlideApp.with(this).clear(this)
    }
}