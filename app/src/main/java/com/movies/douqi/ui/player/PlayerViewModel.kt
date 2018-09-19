package com.movies.douqi.ui.player

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
 * @created_at 2018/9/19.
 * @description
 * @version
 */
class PlayerViewModel @Inject constructor(
        private val schedulers: AppRxSchedulers,
        private val repository: MahuaRepository,
        private val logger: Logger
) : BaseViewModel() {

    private val _data = MutableLiveData<Video>()
    val data: LiveData<Video>
        get() = _data

    fun getVideoInfo(videoId: Long) {
        repository.getVideoInfo(videoId)
                .subscribeOn(schedulers.io)
                .observeOn(schedulers.main)
                .subscribe({
                    if (it.success) {
                        _data.value = it.data
                    }
                }, {
                    logger.e(it)
                }).addTo(disposables)
    }
}