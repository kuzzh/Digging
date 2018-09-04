package com.movies.data.repositories.intheaters

import com.movies.data.entities.Result
import com.movies.douban.entities.DBSubjectResult

/**
 * @author donnieSky
 * @created_at 2018/9/4.
 * @description
 * @version
 */
interface InTheatersDataSource {

    suspend fun getInTheaters(page: Int, pageSize: Int): Result<DBSubjectResult>

}