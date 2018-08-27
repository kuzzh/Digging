package com.movies.douqi.base

import androidx.lifecycle.ViewModel
import com.movies.douqi.inject.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlin.reflect.KClass

/**
 * @author donnieSky
 * @created_at 2018/8/27.
 * @description
 * @version
 */
abstract class BaseBindingActivity<V : KClass<out ViewModel>> : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

}