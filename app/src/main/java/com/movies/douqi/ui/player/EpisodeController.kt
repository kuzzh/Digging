package com.movies.douqi.ui.player

import android.view.View
import com.airbnb.epoxy.TypedEpoxyController
import com.movies.douqi.EpisodeItemBindingModel_
import com.movies.douqi.emptyState
import com.movies.douqi.widget.epoxy.TotalSpanOverride
import com.movies.mahua.entities.Episode

/**
 * @author donnieSky
 * @created_at 2018/9/20.
 * @description
 * @version
 */
open class EpisodeController : TypedEpoxyController<List<Episode?>>() {

    internal var callbacks: Callbacks? = null

    override fun buildModels(data: List<Episode?>) {
        if (data.isNotEmpty()) {
            data.forEachIndexed { index, episode ->
                when {
                    episode != null -> buildItemModel(episode)
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

    private fun buildItemModel(item: Episode): EpisodeItemBindingModel_ {
        return EpisodeItemBindingModel_()
                .id(item.generateStableId())
                .episode(item)
                .clickListener(View.OnClickListener { callbacks?.onItemClicked(item) })

    }

    private fun buildItemPlaceholder(index: Int): EpisodeItemBindingModel_ {
        return EpisodeItemBindingModel_()
                .id("list_item_$index")
    }

    interface Callbacks {
        fun onItemClicked(item: Episode)
    }
}