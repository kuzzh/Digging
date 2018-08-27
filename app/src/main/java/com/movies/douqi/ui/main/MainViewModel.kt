package com.movies.douqi.ui.main

import androidx.lifecycle.LiveData
import com.movies.data.repositories.Repository
import com.movies.douqi.base.BaseViewModel
import com.movies.douqi.utils.SingleLiveEvent
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author donnieSky
 * @created_at 2018/8/24.
 * @description
 * @version
 */
@Singleton
class MainViewModel @Inject constructor(
        private val repository: Repository
) : BaseViewModel() {

    enum class NavigationItem {
        DOUBAN, DYTT, OTHER
    }

    private val mutableNavLiveData = SingleLiveEvent<NavigationItem>()

    val navigationLiveData: LiveData<NavigationItem>
        get() = mutableNavLiveData

    init {
        mutableNavLiveData.value = NavigationItem.DOUBAN
    }

    fun onNavigationItemClicked(item: NavigationItem) {
        mutableNavLiveData.value = item
    }

}