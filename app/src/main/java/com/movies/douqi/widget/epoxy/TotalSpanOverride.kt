package com.movies.douqi.widget.epoxy

import com.airbnb.epoxy.EpoxyModel

/**
 * @author donnieSky
 * @created_at 2018/9/10.
 * @description
 * @version
 */
object TotalSpanOverride : EpoxyModel.SpanSizeOverrideCallback {
    override fun getSpanSize(totalSpanCount: Int, position: Int, itemCount: Int) = totalSpanCount
}