package com.movies.douqi.ui.douban

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.movies.douban.entities.DBListResult
import com.movies.douban.entities.Subject
import com.movies.douban.repositories.DoubanRepository
import com.movies.douqi.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
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

    private val TAG = DoubanViewModel::class.simpleName

    private val _data = MutableLiveData<DBListResult<Subject>>()
    val data: LiveData<DBListResult<Subject>>
        get() = _data

    fun inTheaters() {
        repository.inTheaters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _data.value = it
                }, {
                    Timber.tag(TAG).e(it)
                }).addTo(disposables)
    }
}