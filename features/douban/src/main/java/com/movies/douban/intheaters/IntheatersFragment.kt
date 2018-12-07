package com.movies.douban.intheaters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.movies.core.base.BaseDaggerFragment
import com.movies.douban.R

/**
 * @author donnieSky
 * @created_at 2018/11/27.
 * @description
 * @version
 */
class IntheatersFragment : BaseDaggerFragment() {

    private lateinit var model: IntheatersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_intheaters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        model = ViewModelProviders.of(this, factory).get(IntheatersViewModel::class.java)

        model.intheaters()
    }

}