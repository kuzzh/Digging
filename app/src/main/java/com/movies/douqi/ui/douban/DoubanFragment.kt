package com.movies.douqi.ui.douban

import com.movies.data.resultentities.InTheaterEntryWithFilm
import com.movies.douqi.DoubanItemBindingModel_
import com.movies.douqi.utils.EntryGridEpoxyController
import com.movies.douqi.widget.EntryGridFragment

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
class DoubanFragment : EntryGridFragment<InTheaterEntryWithFilm, InTheatersViewModel>(
        InTheatersViewModel::class.java
) {

    override fun onItemClicked(item: InTheaterEntryWithFilm) {
        model.onItemClicked()
    }

    override fun createController(): EntryGridEpoxyController<InTheaterEntryWithFilm> {
        return object : EntryGridEpoxyController<InTheaterEntryWithFilm>() {
            override fun buildItemModel(item: InTheaterEntryWithFilm): DoubanItemBindingModel_ {
                return super.buildItemModel(item)
                        .label(item.film.ratingsCount?.toString())
            }
        }
    }

}