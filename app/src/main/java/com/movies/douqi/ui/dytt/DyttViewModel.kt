package com.movies.douqi.ui.dytt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.movies.douqi.base.BaseViewModel
import com.movies.dytt.entities.Seed
import com.movies.dytt.entities.SeedList
import com.movies.dytt.repositories.DyttRepository
import com.movies.mahua.entities.VideosResult
import com.movies.mahua.repositories.MahuaRepository
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
class DyttViewModel @Inject constructor(
        private val repository: DyttRepository,
        private val mahua: MahuaRepository
) : BaseViewModel() {

    private val TAG = DyttViewModel::class.simpleName

    private val _data = MutableLiveData<SeedList<Seed>>()
    private val _mahuaData = MutableLiveData<VideosResult>()
    val data: LiveData<SeedList<Seed>>
        get() = _data
    val mahuaData: LiveData<VideosResult>
        get() = _mahuaData


    fun getMovieList(title: String) {
        repository.searchMovie(1, title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _data.value = it
                }, {
                    Timber.tag(TAG).e(it)
                }).addTo(disposables)
    }

    fun searchVideo() {
        mahua.searchVideo("美国队长", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.success) {
                        _mahuaData.value = it
                    }
                }, {
                    Timber.tag(TAG).e(it)
                }).addTo(disposables)
    }
}