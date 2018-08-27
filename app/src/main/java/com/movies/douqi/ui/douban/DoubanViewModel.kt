package com.movies.douqi.ui.douban

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.movies.douban.entities.DBListResult
import com.movies.douban.entities.Subject
import com.movies.douban.repositories.DoubanRepository
import com.movies.douqi.base.BaseViewModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/27.
 * @description
 * @version
 */
@Singleton
class DoubanViewModel @Inject constructor(
        private val repository: DoubanRepository
) : BaseViewModel() {

    private val _data = MutableLiveData<DBListResult<Subject>>()
    val data: LiveData<DBListResult<Subject>>
        get() = _data

}