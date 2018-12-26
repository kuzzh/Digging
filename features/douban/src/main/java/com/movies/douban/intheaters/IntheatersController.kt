package com.movies.douban.intheaters

import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.movies.data.entities.Video
import com.movies.douban.GridItemBindingModel_

/**
 * @author donnieSky
 * @created_at 2018/12/26.
 * @description
 * @version
 */
open class IntheatersController : PagedListEpoxyController<Video>() {

    var isLoading = false
        set(value) {
            if (value != field) {
                field = value
                requestModelBuild()
            }
        }

    override fun buildItemModel(currentPosition: Int,
                                item: Video?): GridItemBindingModel_ {
        return GridItemBindingModel_()
                .id(item?.generateStableId())
                .video(item)
    }


}