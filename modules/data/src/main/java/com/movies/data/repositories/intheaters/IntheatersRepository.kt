package com.movies.data.repositories.intheaters

import com.movies.core.Result
import com.movies.core.Success
import com.movies.data.entities.Video
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
class IntheatersRepository @Inject constructor(
        private val local: LocalIntheaters,
        private val remote: RemoteIntheaters
) {

    private var pageSize = 0

    suspend fun refresh() {
        pageSize = 0
        updateIntheaters(pageSize, true)
    }

    suspend fun loadNextPage() {
        val count = local.getPageSize()
        if (count != null && count > 20) {
            pageSize += 20
            updateIntheaters(pageSize, false)
        } else {
            refresh()
        }
    }

    private suspend fun updateIntheaters(page: Int, resetOnSave: Boolean) {
        val response = remote.inTheaters(page, 20)
        when (response) {
            is Success -> {
                val data = response.data
                if (data != null) {
                    if (resetOnSave) {
                        local.deleteAll()
                    }
                    local.save(data)
                }
            }
        }
    }
}