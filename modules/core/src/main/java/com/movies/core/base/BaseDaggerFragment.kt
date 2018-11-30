package com.movies.core.base

import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/28.
 * @description
 * @version
 */
abstract class BaseDaggerFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

}