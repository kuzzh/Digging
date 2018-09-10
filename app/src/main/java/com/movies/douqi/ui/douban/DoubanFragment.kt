package com.movies.douqi.ui.douban

import com.movies.data.resultentities.InTheaterEntryWithFilm
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

}