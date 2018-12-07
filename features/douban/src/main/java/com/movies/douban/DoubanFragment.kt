package com.movies.douban

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.movies.core.base.DaggerFeature
import com.movies.douban.inject.DaggerDoubanComponent
import dagger.android.AndroidInjector

/**
 * @author donnieSky
 * @created_at 2018/12/6.
 * @description
 * @version
 */
class DoubanFragment : DaggerFeature() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_douban, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val host: NavHostFragment = fragmentManager!!.findFragmentById(R.id.douban) as NavHostFragment? ?: return
    }

    override fun featureInjector(): AndroidInjector<out DaggerFeature> {
        return DaggerDoubanComponent.builder().create(this)
    }

}