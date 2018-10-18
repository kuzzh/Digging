package com.movies.douqi.ui.tivi

import android.view.View
import com.airbnb.epoxy.TypedEpoxyController
import com.movies.data.entities.Tivi
import com.movies.douqi.TiviItemBindingModel_
import com.movies.douqi.emptyState
import com.movies.douqi.widget.epoxy.TotalSpanOverride

/**
 * @author donnieSky
 * @created_at 2018/10/18.
 * @description
 * @version
 */
class TiviController : TypedEpoxyController<List<Tivi?>>() {

    internal var callbacks: Callbacks? = null

    override fun buildModels(data: List<Tivi?>) {
        if (data.isNotEmpty()) {
            data.forEachIndexed { index, tivi ->
                when {
                    tivi != null -> buildItemModel(tivi)
                    else -> buildItemPlaceholder(index)
                }.addTo(this)
            }
        } else {
            emptyState {
                id("list_empty_placeholder")
                spanSizeOverride(TotalSpanOverride)
            }
        }
    }

    private fun buildItemModel(item: Tivi): TiviItemBindingModel_ {
        return TiviItemBindingModel_()
                .id(item.generateStableId())
                .tivi(item)
                .clickListener(View.OnClickListener { callbacks?.onItemClicked(item) })
    }

    private fun buildItemPlaceholder(index: Int): TiviItemBindingModel_ {
        return TiviItemBindingModel_()
                .id("list_item_$index")
    }

    interface Callbacks {
        fun onItemClicked(item: Tivi)
    }
}