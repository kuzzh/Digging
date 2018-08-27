package com.movies.douqi.widget

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author donnieSky
 * @created_at 2018/8/27.
 * @description
 * @version
 */
class SpacingItemDecoration(left: Int, top: Int, right: Int, bottom: Int) : RecyclerView.ItemDecoration() {
    constructor(space: Int) : this(space, space, space, space)

    private val spacingRect = Rect()

    init {
        spacingRect.set(left, top, right, bottom)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.set(spacingRect)
    }
}