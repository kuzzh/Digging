package com.movies.core.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

}