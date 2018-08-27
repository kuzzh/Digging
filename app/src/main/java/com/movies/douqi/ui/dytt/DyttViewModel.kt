package com.movies.douqi.ui.dytt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.movies.douqi.base.BaseViewModel
import com.movies.dytt.entities.Movie
import com.movies.dytt.entities.MovieList
import com.movies.dytt.repositories.DyttRepository
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
        private val repository: DyttRepository
) : BaseViewModel() {

    private val TAG = DyttViewModel::class.simpleName

    private val _data = MutableLiveData<MovieList<Movie>>()
    val data: LiveData<MovieList<Movie>>
        get() = _data

    fun getMovieList() {
        repository.getMovieList(9, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _data.value = it
                }, {
                    Timber.tag(TAG).e(it)
                }).addTo(disposables)
    }
}