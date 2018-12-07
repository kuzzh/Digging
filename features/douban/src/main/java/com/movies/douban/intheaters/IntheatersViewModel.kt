package com.movies.douban.intheaters

import com.movies.data.interactors.UpdateIntheaters
import com.movies.douqi.utils.AppViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
class IntheatersViewModel @Inject constructor(
        private val interactor: UpdateIntheaters
) : AppViewModel() {

    private val TAG = IntheatersViewModel::class.simpleName

    fun intheaters() {
        scope.launch {
            try {
                Timber.tag(TAG).e("begin request intheaters!")
                val intheaters = interactor.intheaters()
                Timber.tag(TAG).d(intheaters.get()?.first()?.title)
                //launchInteractor(interactor, UpdateIntheaters.Params(UpdateIntheaters.Page.REFRESH))
            } catch (e: Exception) {
                Timber.tag(TAG).e(e)
            }
        }
    }

}