package com.movies.douqi.utils

import android.view.View
import com.airbnb.epoxy.paging.PagingEpoxyController
import com.movies.data.Entry
import com.movies.data.resultentities.EntryWithFilm
import com.movies.douqi.DoubanItemBindingModel_
import com.movies.douqi.R
import com.movies.douqi.emptyState
import com.movies.douqi.loadingState
import com.movies.douqi.widget.epoxy.TotalSpanOverride

/**
 * @author donnieSky
 * @created_at 2018/9/10.
 * @description
 * @version
 */
open class EntryGridEpoxyController<LI : EntryWithFilm<out Entry>> : PagingEpoxyController<LI>() {

    internal var callbacks: Callbacks<LI>? = null

    var isLoading = false
        set(value) {
            if (value != field) {
                field = value
                requestModelBuild()
            }
        }

    override fun buildModels(list: MutableList<LI?>) {
        if (!list.isEmpty()) {
            list.forEachIndexed { index, item ->
                when {
                    item != null -> buildItemModel(item)
                    else -> buildItemPlaceholder(index)
                }.addTo(this)
            }
        } else {
            emptyState {
                id("list_empty_placeholder")
                spanSizeOverride(TotalSpanOverride)
            }
        }

        if (isLoading) {
            loadingState {
                id("list_loading_placeholder")
                spanSizeOverride(TotalSpanOverride)
            }
        }
    }

    protected open fun buildItemModel(item: LI): DoubanItemBindingModel_ {
        return DoubanItemBindingModel_()
                .id(item.generateStableId())
                .film(item.film)
                .label("100")
                .labelIcon(R.drawable.ic_eye)
                .clickListener(View.OnClickListener { callbacks?.onItemClicked(item) })
    }

    protected open fun buildItemPlaceholder(index: Int): DoubanItemBindingModel_ {
        return DoubanItemBindingModel_()
                .id("list_item_$index")
    }

    interface Callbacks<in LI> {
        fun onItemClicked(item: LI)
    }
}