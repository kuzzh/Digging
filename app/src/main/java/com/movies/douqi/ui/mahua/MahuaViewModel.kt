package com.movies.douqi.ui.mahua

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.movies.douqi.base.BaseViewModel
import com.movies.mahua.entities.Video
import com.movies.mahua.repositories.MahuaRepository
import com.movies.utils.AppRxSchedulers
import com.movies.utils.Logger
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/9/14.
 * @description
 * @version
 */
class MahuaViewModel @Inject constructor(
        private val schedulers: AppRxSchedulers,
        private val logger: Logger,
        private val repository: MahuaRepository
) : BaseViewModel() {

    private val _data = MutableLiveData<List<Video>>()
    val data: LiveData<List<Video>>
        get() = _data

    fun search(content: String, page: Int) {
        repository.searchVideo(content, page)
                .subscribeOn(schedulers.io)
                .observeOn(schedulers.main)
                .subscribe({
                    if (it.success) {
                        _data.value = it.data
                    }
                }, {
                    logger.e(it)
                })
                .addTo(disposables)
    }

}
